package com.tingeso.ms_4.services;

import com.tingeso.ms_4.clients.SimulacionFeignClient;
import com.tingeso.ms_4.clients.UsuarioFeignClient;
import com.tingeso.ms_4.requests.SolicitudRequest;
import com.tingeso.ms_4.requests.UsuarioRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EvaluacionService {
    private final UsuarioFeignClient usuarioClient;
    private final SimulacionFeignClient simulacionClient;

    public EvaluacionService(UsuarioFeignClient usuarioClient, SimulacionFeignClient simulacionClient) {
        this.usuarioClient = usuarioClient;
        this.simulacionClient = simulacionClient;
    }
    public List<String> cumpleRequisitos(SolicitudRequest solicitudPrestamo) {
        List<String> resultados = new ArrayList<>();
        UsuarioRequest usuario = usuarioClient.getUserByID(solicitudPrestamo.getUsuario());
        double cuotaMensual = simulacionClient.simulateCredit(solicitudPrestamo);
        double relacionCuotaIngreso = (cuotaMensual / (double) usuario.getSalario()) * 100;

        double montoPrestamo = solicitudPrestamo.getValorPropiedad() * solicitudPrestamo.getFinanciamiento()/100;

        // R1: Relación cuota/ingreso
        if (relacionCuotaIngreso > 35) {
            resultados.add("R1: Relación Cuota/Ingreso - No cumple (La relación es " + relacionCuotaIngreso + "%, supera el 35%)");
        } else {
            resultados.add("R1: Relación Cuota/Ingreso - Cumple (La relación es " + relacionCuotaIngreso + "%)");
        }

        List<Double> deudasMensuales = solicitudPrestamo.getDeudasMensuales();
        long countDeudas = deudasMensuales.stream().filter(deuda -> deuda != 0.0).count();
        if (countDeudas > 6) {
            resultados.add("R2: Historial Crediticio - No cumple (Más de la mitad de los meses tienen deudas activas)");
        } else {
            resultados.add("R2: Historial Crediticio - Cumple (Historial de deudas dentro del límite permitido)");
        }

        // R3: Antigüedad Laboral y Estabilidad
        int antiguedadLaboral = solicitudPrestamo.getAntiguedadTrabajo();
        if (antiguedadLaboral <= 1) {
            resultados.add("R3: Antigüedad Laboral - No cumple con la antigüedad de trabajo, demasiado poco.");
        } else if (Objects.equals(solicitudPrestamo.getTipoTrabajo(), "Independiente")) {
            resultados.add("R3: Antigüedad Laboral - Cumple Antigüedad como trabajador independiente, revisar estabilidad de los últimos 2 años");

        }
        else {
            resultados.add("R3: Antigüedad Laboral - Cumple (Antigüedad de " + antiguedadLaboral + " años)");
        }

        double relacionDeudaIngreso = ((usuario.getDeudaTotal() + cuotaMensual) / (double) usuario.getSalario()) *100;
        if (relacionDeudaIngreso > 50) {
            resultados.add("R4: Relación Deuda/Ingreso - No cumple (La relación es " + relacionDeudaIngreso + "%, supera el 50%)");
        } else {
            resultados.add("R4: Relación Deuda/Ingreso - Cumple (La relación es " + relacionDeudaIngreso + "%)");
        }

        double porcentajeFinanciado = solicitudPrestamo.getFinanciamiento();
        if ("Primera Vivienda".equalsIgnoreCase(solicitudPrestamo.getTipoPrestamo()) && porcentajeFinanciado > 80) {
            resultados.add("R5: Monto Máximo de Financiamiento - No cumple (Financiado " + (porcentajeFinanciado) + "%, el máximo es 80% para Primera Vivienda)");
        } else if ("Segunda Vivienda".equalsIgnoreCase(solicitudPrestamo.getTipoPrestamo()) && porcentajeFinanciado > 70) {
            resultados.add("R5: Monto Máximo de Financiamiento - No cumple (Financiado " + (porcentajeFinanciado) + "%, el máximo es 70% para Segunda Vivienda)");
        } else if ("Propiedades Comerciales".equalsIgnoreCase(solicitudPrestamo.getTipoPrestamo()) && porcentajeFinanciado > 60) {
            resultados.add("R5: Monto Máximo de Financiamiento - No cumple (Financiado " + (porcentajeFinanciado) + "%, el máximo es 60% para Propiedades Comerciales)");
        } else if ("Remodelación".equalsIgnoreCase(solicitudPrestamo.getTipoPrestamo()) && porcentajeFinanciado > 50){
            resultados.add("R5: Monto Máximo de Financiamiento - No Cumple (Financiado " + (porcentajeFinanciado) + "%, el máximo es 50% para Remodelación)");
        } else {
            resultados.add("R5: Monto Máximo de Financiamiento - Cumple el máximo permitido por el tipo de préstamo");
        }

        // R6: Edad máxima
        int edadMaxima = 75;
        int edadSolicitante = usuario.getEdad();
        int plazoCredito = solicitudPrestamo.getPlazo();
        if (edadSolicitante + plazoCredito > edadMaxima) {
            resultados.add("R6: Edad del Solicitante - No cumple (El solicitante tendría " + (edadSolicitante + plazoCredito) + " años al finalizar el préstamo, excede el límite de 75 años)");
        } else {
            resultados.add("R6: Edad del Solicitante - Cumple (El solicitante tendría " + (edadSolicitante + plazoCredito) + " años al finalizar el préstamo)");
        }
        // R7: Revisión de capacidad de ahorro
        int resultadoAhorro = 0;

        double saldoCuenta = usuario.getSaldoCuenta();
        List<Double> ingresosMensuales = solicitudPrestamo.getIngresosMensuales();
        // R71: Saldo Mínimo Requerido
        if (saldoCuenta >= 0.10 * montoPrestamo) {
            resultadoAhorro++;
        }

        // R72: Historial de Ahorro Consistente

        boolean saldoPositivo = true;
        double saldoAcumulado = saldoCuenta;
        for (int i = 0; i < deudasMensuales.size(); i++) {
            saldoAcumulado += ingresosMensuales.get(i) - deudasMensuales.get(i);
            if (saldoAcumulado < 0 || deudasMensuales.get(i) > 0.5 * saldoCuenta) { // Verifica si hay retiros significativos o saldo negativo
                saldoPositivo = false;
                break;
            }
        }

        if (saldoPositivo) {
            resultadoAhorro++;
        }


        // R73: Depósitos Periódicos
        double ingresosSuma = ingresosMensuales.stream().mapToDouble(Double::doubleValue).sum();
        int mesesSinDeposito = 0;
        boolean cumpleMontoMinimo = true;

        for (double ingreso : ingresosMensuales) {
            if (ingreso == 0) {
                mesesSinDeposito++;
            }
            if (ingresosSuma < usuario.getSalario() * 0.05 || mesesSinDeposito > 2){
                cumpleMontoMinimo = false;
            }
            else{
                mesesSinDeposito = 0;
            }
        }

        if (cumpleMontoMinimo) {
            resultadoAhorro++;
        }

        // R74: Relación Saldo/Años de Antigüedad
        int antiguedadCuenta = usuario.getAntiguedadCuenta();
        double porcentajeSaldoRequerido = antiguedadCuenta < 2 ? 0.20 : 0.10;
        if (saldoCuenta >= porcentajeSaldoRequerido * montoPrestamo) {
            resultadoAhorro++;
        }


        // R75: Retiros Recientes
        boolean retiroSignificativo = false;
        for (int i = 5; i < deudasMensuales.size(); i++) {
            if (deudasMensuales.get(i) > 0.30 * saldoCuenta) {
                retiroSignificativo = true;
                break;
            }
        }
        if (!retiroSignificativo) {
            resultadoAhorro++;
        }

        if (resultadoAhorro == 5) {
            resultados.add("R7: Capacidad de Ahorro Sólida 5/5");
        } else if (resultadoAhorro > 2) {
            resultados.add("R7: Capacidad de Ahorro Moderada " + resultadoAhorro +"/5");
        } else {
            resultados.add("R7: Capacidad de Ahorro Insuficiente "+ resultadoAhorro +"/5");
        }

        return resultados;
    }


    //Funcionalidad de M6 Añadida en Evaluación de Solicitud
    public List<String> TotalCostCredit(SolicitudRequest request) {
        List<String> mensajes = new ArrayList<>();
        double cuotaPrestamo;
        double montoPrestamo;

        cuotaPrestamo = request.getCuotaMensual();
        montoPrestamo = (double) request.getValorPropiedad() * request.getFinanciamiento() / 100;

        double comisionAdmin = montoPrestamo * request.getComision() / 100;
        double desgravamen = montoPrestamo * request.getSeguroDegravamen() / 100;

        double cuotaMensualNueva = cuotaPrestamo + desgravamen + request.getSeguroIncendio();

        int costoTotal = (int) (cuotaMensualNueva * request.getPlazo() * 12 + comisionAdmin);

        mensajes.add("Calculando los valores del préstamo queda lo siguiente:");
        mensajes.add("Seguro de degravamen: $" + desgravamen + " Mensuales");
        mensajes.add("Costo de comisión por Administración: $" + comisionAdmin + " Monto único añadido al total");
        mensajes.add("El costo total del préstamo quedará en $" + costoTotal + ", mientras que el valor de la cuota será $" + cuotaMensualNueva + ".");
        return mensajes;
    }
}
