package com.fisiunmsm.ayudadoc.alumno.presentation.controller;

import com.fisiunmsm.ayudadoc.alumno.application.service.AlumnoCursoService;
import com.fisiunmsm.ayudadoc.alumno.domain.model.AlumnoCurso;
import com.fisiunmsm.ayudadoc.alumno.infraestructure.mapper.AlumnoCursoMapper;
import com.fisiunmsm.ayudadoc.alumno.presentation.dto.AlumnoCursoRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api-alumno/v1")
public class RegistroCursoController {

    private final AlumnoCursoService alumnoCursoService;

    @Autowired
    public RegistroCursoController(AlumnoCursoService alumnoCursoService) {
        this.alumnoCursoService = alumnoCursoService;
    }

    @PostMapping("/registro-curso")
    public Mono<AlumnoCurso> registrarAlumnoEnCurso(@RequestBody AlumnoCursoRequestDto requestDto) {
        AlumnoCurso model = AlumnoCursoMapper.toDomain(requestDto);
        return alumnoCursoService.registrarAlumnoEnCurso(model);
    }
}
