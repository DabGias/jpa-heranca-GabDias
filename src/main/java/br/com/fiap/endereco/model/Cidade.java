package br.com.fiap.endereco.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cidade")
public class Cidade {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_cidade"
    )
    @SequenceGenerator(
            name = "seq_cidade",
            sequenceName = "seq_cidade",
            allocationSize = 1
    )
    @Column(name = "id_cidade")
    private Long id;

    @Column(name = "nome_cidade")
    private String nome;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "id_estado",
            referencedColumnName = "id_estado",
            foreignKey = @ForeignKey(
                    name = "fk_cidade_estado",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Estado estado;

    public Cidade() {}

    public Cidade(Long id, String nome, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.estado = estado;
    }

    public Cidade(String nome, Estado estado) {
        this.nome = nome;
        this.estado = estado;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", estado=" + estado +
                '}';
    }
}
