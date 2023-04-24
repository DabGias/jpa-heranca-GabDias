package br.com.fiap.endereco.model;

import jakarta.persistence.*;

public class Pais {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_pais"
    )
    @SequenceGenerator(
            name = "seq_pais",
            sequenceName = "seq_pais",
            allocationSize = 1
    )
    @Column(name = "id_pais")
    private Long id;

    @Column(name = "nome_pais")
    private String nome;

    public Pais() {}

    public Pais(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pais(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
