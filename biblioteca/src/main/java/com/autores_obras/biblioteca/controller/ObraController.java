package com.autores_obras.biblioteca.controller;

import com.autores_obras.biblioteca.business.ObraService;
import com.autores_obras.biblioteca.infrastructure.entity.Obra;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<Obra>> buscarObrasPorAutor(@RequestParam Long idAutor){
        return ResponseEntity.ok().body(service.buscarObraPorAutor(idAutor));
    }

    @PutMapping(params = "id")
    public ResponseEntity<Obra> atualizarObra(@RequestParam Long id, @RequestBody Obra obra){
        return ResponseEntity.ok().body(service.atualizarObra(id, obra));
    }

    @DeleteMapping(params = "id")
    public ResponseEntity<Void> deletarObra(@RequestParam Long id){
        service.deletarObra(id);
        return ResponseEntity.ok().build();
    }

}
