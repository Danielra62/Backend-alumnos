package com.fisiunmsm.ayudadoc.alumno.application.service;

import com.fisiunmsm.ayudadoc.alumno.domain.model.AlumnoCurso;
import com.fisiunmsm.ayudadoc.alumno.infraestructure.repository.AlumnoCursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AlumnoCursoService {

    private final AlumnoCursoRepository alumnoCursoRepository;

    @Autowired
    public AlumnoCursoService(AlumnoCursoRepository alumnoCursoRepository) {
        this.alumnoCursoRepository = alumnoCursoRepository;
    }

    public Mono<AlumnoCurso> registrarAlumnoEnCurso(AlumnoCurso nuevo) {
        return alumnoCursoRepository
                .existsByAlumnoIdAndCursoIdAndPeriodoId(nuevo.getAlumnoId(), nuevo.getCursoId(), nuevo.getPeriodoId())
                .flatMap(existe -> {
                    if (existe) {
                        return Mono.error(new IllegalStateException("El alumno ya está registrado en este curso y periodo."));
                    }
                    nuevo.setInstitucionId(1); // siempre será 1
                    nuevo.setEstado("1");      // por defecto activo
                    return alumnoCursoRepository.save(nuevo);
                });
    }
}
