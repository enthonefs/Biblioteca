package com.autores_obras.biblioteca.infrastructure.repository;

import com.autores_obras.biblioteca.infrastructure.entity.Obra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraRepository extends JpaRepository<Obra, Long> {
}
