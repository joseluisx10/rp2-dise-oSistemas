package com.davinci.recuperatorio_dos.service;

import com.davinci.recuperatorio_dos.model.Categoria;
import com.davinci.recuperatorio_dos.model.Producto;
import com.davinci.recuperatorio_dos.repository.CategoriaRepository;
import com.davinci.recuperatorio_dos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private ProductoRepository productoRepository;

    public Categoria save(List<Long> productoIds, Categoria categoria) {
        categoria = categoriaRepository.save(categoria);
        List<Producto> productos = productoRepository.findAllById(productoIds);

        for (Producto producto: productos) {
            producto = categoria.addProducto(producto);
            productoRepository.save(producto);
        }
        return categoriaRepository.save(categoria);
    }
}
