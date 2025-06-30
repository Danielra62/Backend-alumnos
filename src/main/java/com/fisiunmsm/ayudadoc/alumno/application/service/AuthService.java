package com.fisiunmsm.ayudadoc.alumno.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisiunmsm.ayudadoc.alumno.domain.model.Usuario;
import com.fisiunmsm.ayudadoc.alumno.infraestructure.mapper.UsuarioTable;
import com.fisiunmsm.ayudadoc.alumno.infraestructure.repository.AlumnoRepository;
import com.fisiunmsm.ayudadoc.alumno.infraestructure.repository.UsuarioRepository;
import com.fisiunmsm.ayudadoc.shared.helper.AyudocLog;

import reactor.core.publisher.Mono;

@Service
public class AuthService {
    
    @Autowired
private UsuarioRepository usuarioRepository;

@Autowired
private AlumnoRepository alumnoRepository;

public Mono<Usuario> autenticarUsuario(String username, String password) {
    AyudocLog.getInstance().debug("Autenticando usuario: " + username);

    return usuarioRepository.findByUsernameAndPassword(username, password)
        .map(UsuarioTable::toDomainModel)
        .flatMap(usuario ->
            alumnoRepository.findByEmail(username)
                .map(alumno -> {
                    usuario.setCodigoAlumno(alumno.getCodigo()); // Aquí seteas el código
                    return usuario;
                })
                .switchIfEmpty(Mono.just(usuario)) // Si no hay alumno, igual retorna el usuario
        )
        .doOnSuccess(user -> {
            if (user != null) {
                AyudocLog.getInstance().debug("Usuario autenticado: " + user.getNombreVisualizar());
            }
        });
}

}