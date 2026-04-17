package com.autores_obras.biblioteca.controller;

import com.autores_obras.biblioteca.business.ObraService;
import com.autores_obras.biblioteca.infrastructure.entity.Obra;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/obras")
public class ObraController {

    private final ObraService service;

    @GetMapping
    public ResponseEntity<List<Obra>> buscarObras(){
        return ResponseEntity.ok().body(service.buscarObras());
    }

    @GetMapping(params = "idAutor")
    public ResponseEntity<List<Obra>> buscarObrasPorAutor(Long idAutor){
        return ResponseEntity.ok().body(service.buscarObraPorAutor(idAutor));
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<Void> deletarObra(Long id){
        service.deletarObra(id);
        return ResponseEntity.ok().build();
    }

}
