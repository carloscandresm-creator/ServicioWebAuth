package com.example.serviciowebauth.service;

import com.example.serviciowebauth.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public Usuario autenticar(String usuario, String contrasena) {

        if (usuario.equals("admin") && contrasena.equals("1234")) {
            return new Usuario(usuario, contrasena);
        }

        return null;
    }
}