package br.com.fiap.pessoa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pj")
public class PJ extends Pessoa {
    String CNPJ;
    String InscricaoEstadual;
}
