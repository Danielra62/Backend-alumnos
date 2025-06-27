// RegistroController.java (actualizado)
package com.fisiunmsm.ayudadoc.alumno.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fisiunmsm.ayudadoc.alumno.application.service.RegistroService;
import com.fisiunmsm.ayudadoc.alumno.domain.model.RegistroRequest;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api-alumno/v1/auth")
public class RegistroController {

    @Autowired
    private RegistroService registroService;

    @PostMapping("/registro")
    public Mono<String> registrarAlumno(@RequestBody RegistroRequest request) {
        return registroService.registrarAlumno(request);
    }
}