package br.com.fiap.pessoa.model;

import br.com.fiap.endereco.model.Endereco;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_pf")
public class PF extends Pessoa {
    @Column(name = "cpf")
    private String CPF;

    @Column(name = "rg")
    private String RG;

    public PF() {}

    public PF(Long id, String nome, LocalDate nascimento, Endereco endereco, String CPF, String RG) {
        super(id, nome, nascimento, endereco);
        this.CPF = CPF;
        this.RG = RG;
    }

    public PF(String nome, LocalDate nascimento, Endereco endereco, String CPF, String RG) {
        super(nome, nascimento, endereco);
        this.CPF = CPF;
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    @Override
    public String toString() {
        return "PF{" +
                "CPF='" + CPF + '\'' +
                ", RG='" + RG + '\'' +
                "} " + super.toString();
    }
}
