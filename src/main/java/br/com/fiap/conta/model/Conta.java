package br.com.fiap.conta.model;

import br.com.fiap.pessoa.model.Pessoa;

import java.math.BigDecimal;

public abstract class Conta {
    private Long id;
    private int numero;
    private BigDecimal saldo;
    private Pessoa titular;
    private Agencia agencia;

    public Conta() {}

    public Conta(Long id, int numero, BigDecimal saldo, Pessoa titular, Agencia agencia) {
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
        this.titular = titular;
        this.agencia = agencia;
    }

    public Conta(int numero, BigDecimal saldo, Pessoa titular, Agencia agencia) {
        this.numero = numero;
        this.saldo = saldo;
        this.titular = titular;
        this.agencia = agencia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", numero=" + numero +
                ", saldo=" + saldo +
                ", titular=" + titular +
                ", agencia=" + agencia +
                '}';
    }
}
