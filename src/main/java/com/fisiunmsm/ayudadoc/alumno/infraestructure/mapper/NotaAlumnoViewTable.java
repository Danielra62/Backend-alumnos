package com.fisiunmsm.ayudadoc.alumno.infraestructure.mapper;

import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import com.fisiunmsm.ayudadoc.alumno.domain.model.NotaAlumnoView;

@Table("v_notas_por_alumno")
public class NotaAlumnoViewTable {
    
    @Column("codigo")
    private String codigo; // periodo

    @Column("codigoCurso")
    private String codigoCurso;

    @Column("nombre")
    private String nombre;

    @Column("codigoAlumno")
    private String codigoAlumno;

    @Column("apellidos")
    private String apellidos;

    @Column("nombres")
    private String nombres;

    @Column("descripcion")
    private String descripcion;

    @Column("codigoNota")
    private String codigoNota;

    @Column("nota")
    private Double nota;

    // Getters y Setters

    public NotaAlumnoView toDomainModel() {
        NotaAlumnoView model = new NotaAlumnoView();
        model.setCodigo(this.codigo);
        model.setCodigoCurso(this.codigoCurso);
        model.setNombre(this.nombre);
        model.setCodigoAlumno(this.codigoAlumno);
        model.setApellidos(this.apellidos);
        model.setNombres(this.nombres);
        model.setDescripcion(this.descripcion);
        model.setCodigoNota(this.codigoNota);
        model.setNota(this.nota);
        return model;
    }
}
