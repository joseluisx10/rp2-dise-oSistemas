package com.davinci.recuperatorio_dos.model.DTO;

public class UsuarioDTO {

    private Long id;
    private String username;
    private String email;
    private String rol;

    public UsuarioDTO() {}

    public UsuarioDTO(Long id, String username, String email, String rol) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
