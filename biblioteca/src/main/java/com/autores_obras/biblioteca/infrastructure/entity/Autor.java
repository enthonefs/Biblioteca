package com.autores_obras.biblioteca.infrastructure.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "sexo", length = 2)
    private String sexo;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "data_nascimento")
    private String data_nascimento;
    @Column(name = "nacionalidade", nullable = false)
    private String nacionalidade;
    @Column(name = "cpf", unique = true)
    private String cpf;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private List<Obra> obras;
}
