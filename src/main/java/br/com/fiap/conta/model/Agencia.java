package br.com.fiap.conta.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_agencia")
public class Agencia {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_agencia"
    )
    @SequenceGenerator(
            name = "seq_agencia",
            sequenceName = "seq_agencia",
            allocationSize = 1
    )
    @Column(name = "id_agencia")
    private Long id;

    @Column(name = "numero_agencia")
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
