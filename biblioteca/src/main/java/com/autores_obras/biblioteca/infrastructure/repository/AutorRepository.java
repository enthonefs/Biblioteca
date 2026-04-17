package com.autores_obras.biblioteca.infrastructure.repository;

import com.autores_obras.biblioteca.infrastructure.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
