package com.autores_obras.biblioteca.business;

import com.autores_obras.biblioteca.infrastructure.entity.Autor;
import com.autores_obras.biblioteca.infrastructure.repository.AutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutorService {

    private final AutorRepository autorRepository;

    public List<Autor> buscarTodos(){
        return autorRepository.findAll();
    }

    public Autor criarAutor(Autor autor){
        return autorRepository.save(autor);

    }

    public Autor atualizarAutor(Long id, Autor autor){
        Autor autorExistente = autorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Autor não encontrado!"));
        Autor autorAtualizado = Autor.builder()
                .nome(autor.getNome() != null ? autor.getNome() : autorExistente.getNome())
                .sexo(autor.getSexo() != null ? autor.getSexo() : autorExistente.getSexo())
                .email(autor.getEmail() != null ? autor.getEmail() : autorExistente.getEmail())
                .data_nascimento(autor.getData_nascimento() != null ? autor.getData_nascimento() : autorExistente.getData_nascimento())
                .nacionalidade(autor.getNacionalidade() != null ? autor.getNacionalidade() : autorExistente.getNacionalidade())
                .cpf(autor.getCpf() != null ? autor.getCpf() : autorExistente.getCpf())
                .obras(autor.getObras() != null ? autor.getObras() : autorExistente.getObras())
                .id(autorExistente.getId())
                .build();

        return autorRepository.saveAndFlush(autorAtualizado);

    }

    public void deletarAutor(Long id){
        autorRepository.deleteById(id);
    }





}
