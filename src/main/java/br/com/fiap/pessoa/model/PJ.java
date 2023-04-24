package br.com.fiap.pessoa.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_pj")
public class PJ extends Pessoa {
    @Column(name = "cnpj")
    private String CNPJ;

    @Column(name = "inscricao_estadual")
    private String InscricaoEstadual;

    public PJ() {}

    public PJ(Long id, String nome, LocalDate nascimento, String CNPJ, String inscricaoEstadual) {
        super(id, nome, nascimento);
        this.CNPJ = CNPJ;
        InscricaoEstadual = inscricaoEstadual;
    }

    public PJ(String nome, LocalDate nascimento, String CNPJ, String inscricaoEstadual) {
        super(nome, nascimento);
        this.CNPJ = CNPJ;
        InscricaoEstadual = inscricaoEstadual;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getInscricaoEstadual() {
        return InscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        InscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public String toString() {
        return "PJ {" +
                " CNPJ = '" + CNPJ + '\'' +
                ", InscricaoEstadual = '" + InscricaoEstadual + '\'' +
                " } " + super.toString();
    }
}
