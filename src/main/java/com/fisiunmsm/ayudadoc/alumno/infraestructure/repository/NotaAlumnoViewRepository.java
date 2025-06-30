package com.fisiunmsm.ayudadoc.alumno.infraestructure.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.fisiunmsm.ayudadoc.alumno.infraestructure.mapper.NotaAlumnoViewTable;

import reactor.core.publisher.Flux;

public interface NotaAlumnoViewRepository extends R2dbcRepository<NotaAlumnoViewTable, String> {

    @Query("SELECT * FROM v_notas_por_alumno WHERE codigoAlumno = :codigoAlumno")
    Flux<NotaAlumnoViewTable> findByCodigoAlumno(@Param("codigoAlumno") String codigoAlumno);
}
