package com.fisiunmsm.ayudadoc.alumno.presentation.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import com.fisiunmsm.ayudadoc.alumno.domain.model.NotaAlumnoView;
import com.fisiunmsm.ayudadoc.alumno.application.service.NotaAlumnoService;

@RestController
@RequestMapping("/api-alumno/v1/notas")
public class NotaAlumnoController {

    private final NotaAlumnoService notaAlumnoService;

    public NotaAlumnoController(NotaAlumnoService notaAlumnoService) {
        this.notaAlumnoService = notaAlumnoService;
    }

    @GetMapping("/{codigoAlumno}")
    public Flux<NotaAlumnoView> obtenerNotas(@PathVariable String codigoAlumno) {
        return notaAlumnoService.obtenerNotasPorCodigoAlumno(codigoAlumno);
    }
}
