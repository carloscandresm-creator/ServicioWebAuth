package com.example.serviciowebauth.controller;

import com.example.serviciowebauth.model.Usuario;
import com.example.serviciowebauth.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Permite realizar el inicio de sesión
    @PostMapping("/login")
    public String login(@RequestParam String usuario,
                        @RequestParam String contrasena) {

        Usuario usuarioAutenticado =
                usuarioService.autenticar(usuario, contrasena);

        // Verifica si las credenciales son correctas
        if (usuarioAutenticado != null) {
            return "Autenticación satisfactoria";
        }

        // Mensaje cuando las credenciales son incorrectas
        return "Error en la autenticación";
    }
}