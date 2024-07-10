package com.davinci.recuperatorio_dos.service;

import com.davinci.recuperatorio_dos.model.Producto;
import com.davinci.recuperatorio_dos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto agregarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Producto editarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> obtenerProductoPorId(Long id) {
        return productoRepository.findById(id);
    }

    public void eliminarProductoPorId(Long id) {
        productoRepository.deleteById(id);
    }
}
