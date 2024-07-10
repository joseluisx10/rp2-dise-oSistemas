package com.davinci.recuperatorio_dos.service;

import com.davinci.recuperatorio_dos.model.Usuario;
import com.davinci.recuperatorio_dos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

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
}
