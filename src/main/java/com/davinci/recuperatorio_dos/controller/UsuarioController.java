package com.davinci.recuperatorio_dos.controller;

import com.davinci.recuperatorio_dos.model.DTO.UsuarioDTO;
import com.davinci.recuperatorio_dos.model.Usuario;
import com.davinci.recuperatorio_dos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    /*
    * {
    "username" : "jose",
    "password": "123",
    "email": "jose@gmail.com",
    "rol": "admin"
}*/
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioDTO registrarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioRegistrado = usuarioService.registrarUsuario(usuario);
        return new UsuarioDTO(usuarioRegistrado.getId(),usuarioRegistrado.getUsername(), usuarioRegistrado.getEmail(), usuarioRegistrado.getRol());
    }

    @PostMapping("/login")
    public UsuarioDTO autenticarUsuario(@RequestBody Usuario usuario) {
        usuario = usuarioService.autenticarUsuario(usuario);
        return new UsuarioDTO(usuario.getId(), usuario.getUsername(), usuario.getEmail(), usuario.getRol());
    }

    @GetMapping("/{id}")
    public UsuarioDTO obtenerUsuario(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = usuarioService.obtenerUsuario(id);
        Usuario usuario = null;
        if (usuarioOptional.isPresent()) {
            usuario = usuarioOptional.get();
        }
        return new UsuarioDTO(usuario.getId(), usuario.getUsername(), usuario.getEmail(), usuario.getRol());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> editarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        Optional<Usuario> usuarioOptional = usuarioService.obtenerUsuario(id);
        Usuario usuario = null;
        if (usuarioOptional.isPresent()) {
            usuario = usuarioOptional.get();
            usuario.setUsername(usuarioActualizado.getUsername());
            usuario.setEmail(usuarioActualizado.getEmail());
            usuario.setRol(usuarioActualizado.getRol());
            Usuario usuarioGuardado = usuarioService.editarUsuario(usuario);
            UsuarioDTO usuarioDTO = new UsuarioDTO(usuarioGuardado.getId(), usuarioGuardado.getUsername(), usuarioGuardado.getEmail(), usuarioGuardado.getRol());
            return new ResponseEntity<>(usuarioDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}