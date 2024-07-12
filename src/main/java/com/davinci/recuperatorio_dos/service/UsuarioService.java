package com.davinci.recuperatorio_dos.service;

import com.davinci.recuperatorio_dos.model.Pedido;
import com.davinci.recuperatorio_dos.model.Usuario;
import com.davinci.recuperatorio_dos.repository.PedidoRepository;
import com.davinci.recuperatorio_dos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PedidoRepository pedidoRepository;

    public Usuario registrarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> obtenerUsuario(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario editarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario autenticarUsuario(Usuario usuario) {
        usuario = usuarioRepository.autenticar(usuario.getEmail(), usuario.getPassword()).get();
        if (usuario == null) {
            return null;
        }
        return usuario;
    }


    public Usuario createUsuarioAndAddPedidos(Usuario usuario, List<Long> pedidoIds) {
        usuario = usuarioRepository.save(usuario);
        List<Pedido> pedidos = pedidoRepository.findAllById(pedidoIds);
        for (Pedido pedido : pedidos) {
            pedido = usuario.addOrder(pedido);
            pedidoRepository.save(pedido);
        }
        return usuarioRepository.save(usuario);
    }
}
