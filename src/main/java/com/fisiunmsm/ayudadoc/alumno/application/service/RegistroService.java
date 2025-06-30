package com.fisiunmsm.ayudadoc.alumno.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fisiunmsm.ayudadoc.alumno.domain.model.RegistroRequest;
import com.fisiunmsm.ayudadoc.alumno.infraestructure.repository.AlumnoRepository;
import com.fisiunmsm.ayudadoc.alumno.infraestructure.repository.UsuarioRepository;
import com.fisiunmsm.ayudadoc.shared.helper.AyudocLog;

import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
public class RegistroService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private AlumnoRepository alumnoRepository;

    public Mono<String> registrarAlumno(RegistroRequest request) {
        String nombreVisualizar = request.getNombres() + " " + request.getApellidos();
        String fechaActual = LocalDateTime.now().toString();
        
        // PASO 1: Verificar si el username ya existe en la tabla "usuario"
        return usuarioRepository.findByUsername(request.getUsername())
            .flatMap(existingUser -> {
                // 1.1: Si el usuario ya existe, retornar mensaje de error
                AyudocLog.getInstance().info("El usuario ya se encuentra registrado: " + request.getUsername());
                return Mono.just("El usuario ya se encuentra registrado");
            })
            .switchIfEmpty(
                // 1.2: Si no existe, proceder con el registro del usuario
                usuarioRepository.findMaxId()
                    .defaultIfEmpty(0)
                    .flatMap(lastId -> {
                        int newUserId = lastId + 1;
                        
                        // Registrar en tabla usuario
                        return usuarioRepository.insertWithId(
                            newUserId,
                            request.getUsername(),
                            request.getPassword(),
                            nombreVisualizar,
                            "1",
                            fechaActual
                        ).thenReturn(newUserId);
                    })
                    .flatMap(userId -> 
                        // PASO 2: Verificar si el email ya existe en la tabla "alumno"
                        alumnoRepository.findByEmail(request.getUsername())
                            .flatMap(existingAlumno -> {
                                // 2.1: Si el email existe, solo actualizar el usuarioid
                                AyudocLog.getInstance().info("Email ya registrado, actualizando usuarioid para: " + request.getUsername());
                                return alumnoRepository.updateUsuarioId(request.getUsername(), userId)
                                    .thenReturn("Usuario registrado y vinculado con alumno existente");
                            })
                            .switchIfEmpty(
                                // 2.2: Si el email no existe, registrar nuevo alumno
                                alumnoRepository.insertAlumno(
                                    request.getCodigo(),
                                    request.getNombres(),
                                    request.getApellidos(),
                                    request.getUsername(),
                                    "1",
                                    userId
                                ).thenReturn("Registro completo exitoso")
                            )
                    )
            )
            .doOnSuccess(success -> 
                AyudocLog.getInstance().debug("Operación completada: " + success)
            )
            .doOnError(error -> 
                AyudocLog.getInstance().error("Error en registro: " + error.getMessage())
            );
    }
}