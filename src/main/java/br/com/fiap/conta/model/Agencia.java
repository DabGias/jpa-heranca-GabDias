package br.com.fiap.conta.model;

public class Agencia {
    private Long id;
    private int numero;

    public Agencia() {}

    public Agencia(Long id, int numero) {
        this.id = id;
        this.numero = numero;
    }

    public Agencia(int numero) {
        this.numero = numero;
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

    @Override
    public String toString() {
        return "Agencia{" +
                "id=" + id +
                ", numero=" + numero +
                '}';
    }
}
