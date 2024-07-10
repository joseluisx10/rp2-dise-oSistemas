package com.davinci.recuperatorio_dos.controller;

import com.davinci.recuperatorio_dos.model.Categoria;
import com.davinci.recuperatorio_dos.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    /***
     * {
     *     "nombre" : "botines",
     *     "productos": []
     * }
     * {
     *
     *     "nombre": "zapato nike",
     *     "descripcion": "zapato nike",
     *     "precio": 212.2,
     *
     * }*/

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> agregarCategoria(@RequestParam List<Long> productoIds, @RequestBody Categoria categoria) {

        return new ResponseEntity<>(categoriaService.save(productoIds, categoria), HttpStatus.OK);
    }

}
