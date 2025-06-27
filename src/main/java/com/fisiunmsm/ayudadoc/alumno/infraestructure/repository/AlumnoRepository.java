// AlumnoRepository.java (actualizado)
package com.fisiunmsm.ayudadoc.alumno.infraestructure.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

import com.fisiunmsm.ayudadoc.alumno.infraestructure.mapper.AlumnoTable;

import reactor.core.publisher.Mono;

public interface AlumnoRepository extends R2dbcRepository<AlumnoTable, Long> {
    
    @Query("SELECT * FROM alumno WHERE email = :email")
    Mono<AlumnoTable> findByEmail(String email);
    
    @Query("SELECT * FROM alumno WHERE codigo = :codigo")
    Mono<AlumnoTable> findByCodigo(String codigo);
    
    @Query("INSERT INTO alumno (codigo, nombres, apellidos, email, estado, usuarioid) " +
           "VALUES (:codigo, :nombres, :apellidos, :email, :estado, :usuarioid)")
    Mono<Void> insertAlumno(
        String codigo,
        String nombres,
        String apellidos,
        String email,
        String estado,
        Integer usuarioid
    );
    
    // Nuevo método para actualizar el usuarioid cuando el email ya existe
    @Query("UPDATE alumno SET usuarioid = :usuarioId WHERE email = :email")
    Mono<Void> updateUsuarioId(String email, Integer usuarioId);
}