package com.davinci.recuperatorio_dos.controller;

import com.davinci.recuperatorio_dos.model.Pedido;
import com.davinci.recuperatorio_dos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;
    /**
     * {
     * "fecha": "2024-07-10",
     * "estado": "PENDIENTE"
     * }*/

//http://localhost:8080/pedidos?productoIds=1,....
    @PostMapping
    public Pedido nuevoPedido(@RequestParam List<Long> productoIds, @RequestBody Pedido pedido) {
        // Asignar fecha actual al pedido

        return pedidoService.nuevoPedido(pedido, productoIds);
    }

    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoService.findAll();
    }

    @GetMapping("/{id}")
    public Pedido obtenerPedido(@PathVariable Long id) {
        Optional<Pedido> pedidoOptional = pedidoService.findById(id);
        Pedido pedido = null;
        if (pedidoOptional.isPresent()) {
            pedido = pedidoOptional.get();
        }
        return pedido;
    }

    @PutMapping("/{id}")
    public  ResponseEntity<Pedido> actualizarEstadoPedido(@PathVariable Long id, @RequestBody Pedido pedidoActualizado) {
        Optional<Pedido> pedidoOptional = pedidoService.findById(id);

        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            pedido.setEstado(pedidoActualizado.getEstado());
            Pedido pedidoGuardado = pedidoService.actualizarEstadoPedido(pedido);
            return new ResponseEntity<>(pedidoGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



}
