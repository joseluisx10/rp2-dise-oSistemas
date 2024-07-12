package com.davinci.recuperatorio_dos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date fecha;
    private String estado; // Puede ser "PENDIENTE", "EN PROCESO", "ENVIADO", etc.

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    @JsonIgnore
    private Usuario usuario; // Relación muchos a uno con Usuario

    @ManyToMany
    @JoinTable(
            name = "Pedido_Producto",
            joinColumns = @JoinColumn(name = "pedido_id"),
            inverseJoinColumns = @JoinColumn(name = "producto_id")
    )
    @JsonIgnore
    private List<Producto> productos;

    public Pedido() {
        this.productos = new ArrayList<>();
    }

    public Pedido(Date fecha, String estado, Usuario cliente) {
        this.fecha = fecha;
        this.estado = estado;
        this.usuario = cliente;

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getCliente() {
        return usuario;
    }

    public void setCliente(Usuario cliente) {
        this.usuario = cliente;
    }


    public List<Producto> getProductos() {
        return productos;
    }


    public void setUser(Usuario usuario) {
        this.usuario = usuario;
    }
}
