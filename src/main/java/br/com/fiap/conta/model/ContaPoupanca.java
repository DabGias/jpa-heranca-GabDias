package br.com.fiap.conta.model;

import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@DiscriminatorValue("CP")
public class ContaPoupanca extends Conta {
    @Column(name = "aniversario_conta_poupanca")
    private int aniversario;

    public ContaPoupanca() {}

    public ContaPoupanca(Long id, int numero, BigDecimal saldo, Pessoa titular, Agencia agencia, int aniversario) {
        super(id, numero, saldo, titular, agencia);
        this.aniversario = aniversario;
    }

    public ContaPoupanca(int numero, BigDecimal saldo, Pessoa titular, Agencia agencia, int aniversario) {
        super(numero, saldo, titular, agencia);
        this.aniversario = aniversario;
    }

    public int getAniversario() {
        return aniversario;
    }

    public void setAniversario(int aniversario) {
        this.aniversario = aniversario;
    }

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "aniversario=" + aniversario +
                "} " + super.toString();
    }
}
