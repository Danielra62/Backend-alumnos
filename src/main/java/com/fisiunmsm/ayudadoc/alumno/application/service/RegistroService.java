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

        AyudocLog.getInstance().info("Intentando registrar usuario: " + request.getUsername());

        // Paso 1: Verificar si el username ya existe en tabla "usuario"
        return usuarioRepository.findByUsername(request.getUsername())
            .flatMap(existingUser -> {
                // Si el usuario ya existe
                AyudocLog.getInstance().warn("El usuario ya se encuentra registrado: " + request.getUsername());
                return Mono.just("El usuario ya se encuentra registrado");
            })
            .switchIfEmpty(
                // Si no existe, proceder con el registro
                usuarioRepository.findMaxId()
                    .defaultIfEmpty(0)
                    .flatMap(lastId -> {
                        int newUserId = lastId + 1;
                        AyudocLog.getInstance().debug("Generando nuevo ID de usuario: " + newUserId);

                        // Registrar en tabla usuario
                        return usuarioRepository.insertWithId(
                                newUserId,
                                request.getUsername(),
                                request.getPassword(),
                                nombreVisualizar,
                                "1", // estado
                                fechaActual
                        ).thenReturn(newUserId);
                    })
                    .flatMap(userId -> 
                        // Paso 2: Verificar si el email ya existe en tabla "alumno"
                        alumnoRepository.findByEmail(request.getUsername())
                            .flatMap(existingAlumno -> {
                                // Email existe → actualizar usuarioId
                                AyudocLog.getInstance().info("Email ya registrado, actualizando usuarioId: " + request.getUsername());
                                return alumnoRepository.updateUsuarioId(request.getUsername(), userId)
                                    .thenReturn("Usuario registrado y vinculado con alumno existente");
                            })
                            .switchIfEmpty(
                                // Email no existe → registrar nuevo alumno
                                alumnoRepository.insertAlumno(
                                    request.getCodigo(),
                                    request.getNombres(),
                                    request.getApellidos(),
                                    request.getUsername(),
                                    "1", // estado
                                    userId
                                ).thenReturn("Registro completo exitoso")
                            )
                    )
            )
            .doOnSuccess(result -> 
                AyudocLog.getInstance().info("Operación completada: " + result)
            )
            .doOnError(error -> 
                AyudocLog.getInstance().error("Error en el registro: " + error.getMessage())
            );
    }
}
