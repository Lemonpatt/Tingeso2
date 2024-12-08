package com.tingeso.ms_2.services;

import com.tingeso.ms_2.entities.Usuario;
import com.tingeso.ms_2.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;


    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUserByID(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario updateUser(Usuario user) {
        return usuarioRepository.save(user);
    }

    public void deleteUser(Long id) throws Exception {
        try{
            usuarioRepository.deleteById(id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
