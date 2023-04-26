package br.com.fiap.conta.model;

import br.com.fiap.pessoa.model.Pessoa;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente() {}

    public ContaCorrente(Long id, int numero, BigDecimal saldo, Pessoa titular, Agencia agencia, double limite) {
        super(id, numero, saldo, titular, agencia);
        this.limite = limite;
    }

    public ContaCorrente(int numero, BigDecimal saldo, Pessoa titular, Agencia agencia, double limite) {
        super(numero, saldo, titular, agencia);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "limite=" + limite +
                "} " + super.toString();
    }
}
