package com.davinci.recuperatorio_dos.controller;

import com.davinci.recuperatorio_dos.model.*;
import com.davinci.recuperatorio_dos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoService.agregarProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto editarProducto(@PathVariable Long id, @RequestBody Producto productoActualizado) {
        productoActualizado.setId(id);
        return productoService.editarProducto(productoActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarProductoPorId(@PathVariable Long id) {
        productoService.eliminarProductoPorId(id);
    }

    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable Long id) {
        Optional<Producto> productoOptional = productoService.obtenerProductoPorId(id);
        Producto producto = null;
        if (productoOptional.isPresent()) {
            producto = productoOptional.get();
        }
        return producto;
    }


}