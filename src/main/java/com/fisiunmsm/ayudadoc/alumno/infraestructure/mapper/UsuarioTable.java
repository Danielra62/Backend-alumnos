package com.fisiunmsm.ayudadoc.alumno.infraestructure.mapper;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import com.fisiunmsm.ayudadoc.alumno.domain.model.Usuario;

@Table("usuario")
public class UsuarioTable {
    @Id
    private Integer id;
    private String username;
    private String password;
    
    @Column("nombrevisualizar")
    private String nombreVisualizar;
    
    private String estado;
    
    @Column("fechacreacion")
    private String fechaCreacion;
    
    @Column("fechavalidado")
    private String fechaValidado;
    
    @Column("fechaultlogin")
    private String fechaUltLogin;

    // Constructor
    public UsuarioTable(Integer id, String username, String password, 
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

    // Getters y Setters (para todos los campos)

    // ... (implementa todos los getters y setters para cada campo)

    // Métodos de mapeo
    public static UsuarioTable fromDomainModel(Usuario usuario) {
        return new UsuarioTable(
            null, // ID se generará automáticamente
            usuario.getUsername(),
            usuario.getPassword(),
            usuario.getNombreVisualizar(),
            usuario.getEstado(),
            usuario.getFechaCreacion(),
            null, // fechavalidado
            null  // fechaultlogin
        );
    }
    

    public Usuario toDomainModel() {
        Usuario usuario = new Usuario();
        usuario.setId(this.id);
        usuario.setUsername(this.username);
        usuario.setPassword(this.password);
        usuario.setNombreVisualizar(this.nombreVisualizar);
        usuario.setEstado(this.estado);
        usuario.setFechaCreacion(this.fechaCreacion);
        usuario.setFechaValidado(this.fechaValidado);
        usuario.setFechaUltLogin(this.fechaUltLogin);
        return usuario;
    }


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

    public String getFechacreacion() {
        return fechaCreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechaCreacion = fechacreacion;
    }

    public String getFechavalidado() {
        return fechaValidado;
    }

    public void setFechavalidado(String fechavalidado) {
        this.fechaValidado = fechavalidado;
    }

    public String getFechaultlogin() {
        return fechaUltLogin;
    }

    public void setFechaultlogin(String fechaultlogin) {
        this.fechaUltLogin = fechaultlogin;
    }
    // Constructores, getters y setters
    // ... (implementa todos)
}