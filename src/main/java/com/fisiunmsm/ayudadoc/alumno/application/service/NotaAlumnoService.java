package com.fisiunmsm.ayudadoc.alumno.application.service;

import org.springframework.stereotype.Service;
import com.fisiunmsm.ayudadoc.alumno.domain.model.NotaAlumnoView;
import com.fisiunmsm.ayudadoc.alumno.infraestructure.repository.NotaAlumnoViewRepository;
import com.fisiunmsm.ayudadoc.alumno.infraestructure.mapper.NotaAlumnoViewTable;

import reactor.core.publisher.Flux;

@Service
public class NotaAlumnoService {

    private final NotaAlumnoViewRepository repository;

    public NotaAlumnoService(NotaAlumnoViewRepository repository) {
        this.repository = repository;
    }

    public Flux<NotaAlumnoView> obtenerNotasPorCodigoAlumno(String codigoAlumno) {
        return repository.findByCodigoAlumno(codigoAlumno)
                .map(NotaAlumnoViewTable::toDomainModel);
    }
}
