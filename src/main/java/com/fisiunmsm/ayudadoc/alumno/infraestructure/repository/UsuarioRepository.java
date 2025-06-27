package com.fisiunmsm.ayudadoc.alumno.infraestructure.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;

import com.fisiunmsm.ayudadoc.alumno.infraestructure.mapper.UsuarioTable;
import reactor.core.publisher.Mono;

public interface UsuarioRepository extends R2dbcRepository<UsuarioTable, Integer> {
    @Query("SELECT * FROM usuario WHERE username = :username AND password = :password AND estado = '1'")
    Mono<UsuarioTable> findByUsernameAndPassword(String username, String password);

    // Método para encontrar usuario por username
    @Query("SELECT * FROM usuario WHERE username = :username")
    Mono<UsuarioTable> findByUsername(@Param("username") String username);
    
    // Método para obtener el máximo ID
    @Query("SELECT COALESCE(MAX(id), 0) FROM usuario")
    Mono<Integer> findMaxId();
    
    // Método para insertar con ID específico (opcional)
    @Query("INSERT INTO usuario (id, username, password, nombrevisualizar, estado, fechacreacion) " +
           "VALUES (:id, :username, :password, :nombrevisualizar, :estado, :fechacreacion)")
    Mono<Void> insertWithId(
        @Param("id") Integer id,
        @Param("username") String username,
        @Param("password") String password,
        @Param("nombrevisualizar") String nombreVisualizar,
        @Param("estado") String estado,
        @Param("fechacreacion") String fechaCreacion
    );


}

