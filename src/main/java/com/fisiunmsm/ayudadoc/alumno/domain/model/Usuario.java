package com.fisiunmsm.ayudadoc.alumno.domain.model;

public class Usuario {
    private Integer id;
    private String username;
    private String password;
    private String nombreVisualizar;
    private String estado;
    private String fechaCreacion;
    private String fechaValidado;
    private String fechaUltLogin;
    private String codigoAlumno;


    // Constructor por defecto (requerido por Spring)
    public Usuario() {
    }

    // Constructor mínimo
    public Usuario(Integer id, String username, String password, String nombreVisualizar) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombreVisualizar = nombreVisualizar;
    }

    // Constructor completo
    public Usuario(Integer id, String username, String password,
                   String nombreVisualizar, String estado,
                   String fechaCreacion, String fechaValidado,
                   String fechaUltLogin) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.nombreVisualizar = nombreVisualizar;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.fechaValidado = fechaValidado;
        this.fechaUltLogin = fechaUltLogin;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreVisualizar() {
        return nombreVisualizar;
    }

    public void setNombreVisualizar(String nombreVisualizar) {
        this.nombreVisualizar = nombreVisualizar;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getFechaValidado() {
        return fechaValidado;
    }

    public void setFechaValidado(String fechaValidado) {
        this.fechaValidado = fechaValidado;
    }

    public String getFechaUltLogin() {
        return fechaUltLogin;
    }

    public void setFechaUltLogin(String fechaUltLogin) {
        this.fechaUltLogin = fechaUltLogin;
    }

    public String getCodigoAlumno() {
    return codigoAlumno;
}
    public void setCodigoAlumno(String codigoAlumno) {
    this.codigoAlumno = codigoAlumno;
}

    // Método toString() para logging/debug
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nombreVisualizar='" + nombreVisualizar + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}