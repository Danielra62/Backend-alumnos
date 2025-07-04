package com.fisiunmsm.ayudadoc.alumno.infraestructure.mapper;

import com.fisiunmsm.ayudadoc.alumno.domain.model.AlumnoCurso;
import com.fisiunmsm.ayudadoc.alumno.presentation.dto.AlumnoCursoRequestDto;

public class AlumnoCursoMapper {

    public static AlumnoCurso toDomain(AlumnoCursoRequestDto dto) {
        AlumnoCurso model = new AlumnoCurso();
        model.setAlumnoId(dto.getAlumnoId());
        model.setCursoId(dto.getCursoId());
        model.setPeriodoId(dto.getPeriodoId());
        model.setDepartamentoId(dto.getDepartamentoId());
        // institucionId y estado se setean en el servicio
        return model;
    }
}
