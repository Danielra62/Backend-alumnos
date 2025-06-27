// RegistroRequest.java (actualizado)
package com.fisiunmsm.ayudadoc.alumno.domain.model;

public class RegistroRequest {
    private String codigo;
    private String username;
    private String password;
    private String nombres;
    private String apellidos;
    
    // Getters y Setters
    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }
    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }
}