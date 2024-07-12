package com.davinci.recuperatorio_dos.service;

import com.davinci.recuperatorio_dos.model.Pedido;
import com.davinci.recuperatorio_dos.model.Producto;
import com.davinci.recuperatorio_dos.repository.PedidoRepository;
import com.davinci.recuperatorio_dos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ProductoRepository productoRepository;

    public Pedido nuevoPedido(Pedido pedido, List<Long> productosIds) {
        List<Producto> productos = productoRepository.findAllById(productosIds);
        pedido.getProductos().addAll(productos);
        Pedido savedPedido = pedidoRepository.save(pedido);

        for (Producto producto : productos) {
            producto.getPedidos().add(savedPedido);
            productoRepository.save(producto);
        }

        return savedPedido;
    }



    public List<Pedido> findAll() {
        return pedidoRepository.findAllConProductos();
    }

    public Optional<Pedido> findById(Long id) {
        return pedidoRepository.findById(id);
    }


    public Pedido actualizarEstadoPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
}
