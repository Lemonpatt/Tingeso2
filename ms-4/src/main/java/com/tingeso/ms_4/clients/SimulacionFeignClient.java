package com.tingeso.ms_4.clients;

import com.tingeso.ms_4.requests.SolicitudRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "ms-1",
        path = "/api/v1/simulacion"
)
public interface SimulacionFeignClient {
    @PostMapping("/")
    double simulateCredit(@RequestBody SolicitudRequest request);

}