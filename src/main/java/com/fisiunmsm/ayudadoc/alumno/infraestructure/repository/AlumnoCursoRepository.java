package com.fisiunmsm.ayudadoc.alumno.infraestructure.repository;

import com.fisiunmsm.ayudadoc.alumno.domain.model.AlumnoCurso;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AlumnoCursoRepository extends ReactiveCrudRepository<AlumnoCurso, Long> {
    Mono<Boolean> existsByAlumnoIdAndCursoIdAndPeriodoId(Long alumnoId, Integer cursoId, Integer periodoId);
}
