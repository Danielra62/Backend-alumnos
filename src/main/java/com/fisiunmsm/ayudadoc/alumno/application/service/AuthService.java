package com.fisiunmsm.ayudadoc.alumno.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisiunmsm.ayudadoc.alumno.domain.model.Usuario;
import com.fisiunmsm.ayudadoc.alumno.infraestructure.mapper.UsuarioTable;
import com.fisiunmsm.ayudadoc.alumno.infraestructure.repository.UsuarioRepository;
import com.fisiunmsm.ayudadoc.shared.helper.AyudocLog;

import reactor.core.publisher.Mono;

@Service
public class AuthService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Mono<Usuario> autenticarUsuario(String username, String password) {
    AyudocLog.getInstance().debug("Intentando autenticar al usuario: " + username);

    return usuarioRepository.findByUsernameAndPassword(username, password)
        .map(UsuarioTable::toDomainModel)
        .doOnSuccess(user -> {
            if (user != null) {
                AyudocLog.getInstance().info("Usuario autenticado exitosamente: " + user.getNombreVisualizar());
            } else {
                AyudocLog.getInstance().warn("Credenciales incorrectas para el usuario: " + username);
            }
        })
        .doOnError(error -> {
            AyudocLog.getInstance().error("Error durante la autenticación: " + error.getMessage());
        });
}

}
