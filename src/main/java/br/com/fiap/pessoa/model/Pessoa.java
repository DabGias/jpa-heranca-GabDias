package br.com.fiap.pessoa.model;

import br.com.fiap.endereco.model.Endereco;
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

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "id_endereco",
            referencedColumnName = "id_endereco",
            foreignKey = @ForeignKey(
                    name = "fk_pessoa_endereco",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Endereco endereco;

    public Pessoa() {}

    public Pessoa(Long id, String nome, LocalDate nascimento, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
        this.endereco = endereco;
    }

    public Pessoa(String nome, LocalDate nascimento, Endereco endereco) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.endereco = endereco;
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

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
