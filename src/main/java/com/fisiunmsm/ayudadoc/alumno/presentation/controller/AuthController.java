package com.fisiunmsm.ayudadoc.alumno.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisiunmsm.ayudadoc.alumno.application.service.AuthService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api-alumno/v1/auth")
public class AuthController {
    
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public Mono<ResponseEntity<LoginResponse>> login(@RequestBody LoginRequest loginRequest) {
        return authService.autenticarUsuario(
            loginRequest.getUsername(), 
            loginRequest.getPassword()
        )
        .map(usuario -> {
            LoginResponse response = new LoginResponse(
                usuario.getUsername(),
                usuario.getNombreVisualizar(),
                usuario.getCodigoAlumno()
            );
            return ResponseEntity.ok(response);
        })
        .switchIfEmpty(Mono.just(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build()));
    }
}

// Clase DTO para la solicitud de login
class LoginRequest {
    private String username;
    private String password;

    // Getters y Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

// Clase DTO para la respuesta de login
class LoginResponse {
    private String username;
    private String nombreVisualizar;
    private String codigoAlumno;
    
    // Constructor
    public LoginResponse(String username, String nombreVisualizar, String codigoAlumno) {
        this.username = username;
        this.nombreVisualizar = nombreVisualizar;
        this.codigoAlumno = codigoAlumno;
    }
    
    // Getters y Setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    
    public String getNombreVisualizar() { return nombreVisualizar; }
    public void setNombreVisualizar(String nombreVisualizar) { this.nombreVisualizar = nombreVisualizar; }
    
    public String getCodigoAlumno() { return codigoAlumno; }
    public void setCodigoAlumno(String codigoAlumno) { this.codigoAlumno = codigoAlumno; }
}
