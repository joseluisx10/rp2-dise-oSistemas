package com.davinci.recuperatorio_dos.controller;

import com.davinci.recuperatorio_dos.model.Pedido;
import com.davinci.recuperatorio_dos.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping
    public Pedido nuevoPedido(@RequestBody Pedido pedido) {
        // Asignar fecha actual al pedido
        pedido.setFecha(LocalDateTime.now());
        return pedidoService.save(pedido);
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
            Pedido pedidoGuardado = pedidoService.save(pedido);
            return new ResponseEntity<>(pedidoGuardado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
