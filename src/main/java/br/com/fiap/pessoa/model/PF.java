package br.com.fiap.pessoa.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pf")
public class PF extends Pessoa{
    String CPF;
    String RG;
}
