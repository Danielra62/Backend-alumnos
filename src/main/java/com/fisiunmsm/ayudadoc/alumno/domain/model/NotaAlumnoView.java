package com.fisiunmsm.ayudadoc.alumno.domain.model;

public class NotaAlumnoView {
    private String codigo; // Periodo académico
    private String codigoCurso;
    private String nombre;
    private String codigoAlumno;
    private String apellidos;
    private String nombres;
    private String descripcion; // Componente
    private String codigoNota;
    private Double nota;

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getCodigoCurso() {
        return codigoCurso;
    }
    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCodigoAlumno() {
        return codigoAlumno;
    }
    public void setCodigoAlumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getNombres() {
        return nombres;
    }
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getCodigoNota() {
        return codigoNota;
    }
    public void setCodigoNota(String codigoNota) {
        this.codigoNota = codigoNota;
    }
    public Double getNota() {
        return nota;
    }
    public void setNota(Double nota) {
        this.nota = nota;
    }

    // Getters y Setters
}
    