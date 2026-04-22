package com.autores_obras.biblioteca.business;

import com.autores_obras.biblioteca.infrastructure.entity.Autor;
import com.autores_obras.biblioteca.infrastructure.entity.Obra;
import com.autores_obras.biblioteca.infrastructure.exceptions.ResourceNotFoundException;
import com.autores_obras.biblioteca.infrastructure.repository.AutorRepository;
import com.autores_obras.biblioteca.infrastructure.repository.ObraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObraService {
    
    private final ObraRepository obraRepository;
    private final AutorRepository autorRepository;

    public List<Obra> buscarObras(){
        return obraRepository.findAll();
    }
    
    public List<Obra> buscarObraPorAutor(Long idAutor){
        Autor autorExistente = autorRepository.findById(idAutor).orElseThrow(
                () -> new ResourceNotFoundException("Autor não encontrado!"));

        return autorExistente.getObras();

    }

    public Obra atualizarObra(Long id, Obra obra){
        Obra obraExistente = obraRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Obra não encontrada!"));
        Obra obraAtualizada = Obra.builder()
                .id(obraExistente.getId())
                .nome(obra.getNome() != null ? obra.getNome() : obraExistente.getNome())
                .descricao(obra.getDescricao() != null ? obra.getDescricao() : obraExistente.getDescricao())
                .data(obra.getData() != null ? obra.getData() : obraExistente.getData())
                .build();

        return obraRepository.saveAndFlush(obraAtualizada);
    }

    public void deletarObra(Long id){
        obraRepository.deleteById(id);
    }
}
