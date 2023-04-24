package br.com.fiap.pessoa.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_pessoa"
    )
    @SequenceGenerator(
            name = "seq_pessoa",
            sequenceName = "seq_pessoa",
            allocationSize = 1
    )
    @Column(name = "id_pessoa")
    private Long id;

    @Column(name = "nome_pessoa")
    private String nome;

    @Temporal(TemporalType.DATE)
    @Column(name = "dt_nascimento_pessoa")
    private LocalDate nascimento;

    public Pessoa() {}

    public Pessoa(Long id, String nome, LocalDate nascimento) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public Pessoa(String nome, LocalDate nascimento) {
        this.nome = nome;
        this.nascimento = nascimento;
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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nascimento=" + nascimento +
                '}';
    }
}
