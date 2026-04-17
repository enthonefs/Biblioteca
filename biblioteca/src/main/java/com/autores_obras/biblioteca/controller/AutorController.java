package com.autores_obras.biblioteca.controller;

import com.autores_obras.biblioteca.business.AutorService;
import com.autores_obras.biblioteca.infrastructure.entity.Autor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/autor")
public class AutorController {

    private final AutorService service;

    @GetMapping
    public ResponseEntity<List<Autor>> buscarAutores(){
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Autor> criarAutor(@RequestBody Autor autor){
        return ResponseEntity.ok().body(service.criarAutor(autor));
    }

    @PutMapping(params = "id")
    public ResponseEntity<Autor> atualizarAutor(@RequestParam Long id, @RequestBody Autor autor){
        return ResponseEntity.ok().body(service.atualizarAutor(id, autor));
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<Void> deletarAutor(@RequestParam Long id){
        service.deletarAutor(id);
        return ResponseEntity.ok().build();
    }
}
