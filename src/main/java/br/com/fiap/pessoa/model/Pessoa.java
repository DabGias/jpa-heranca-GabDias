package br.com.fiap.pessoa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tb_pessoa")
public abstract class Pessoa {
    private Long id;
    private String nome;
    private LocalDate nascimento;
}
