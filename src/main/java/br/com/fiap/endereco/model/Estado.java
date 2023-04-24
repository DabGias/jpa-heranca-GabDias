package br.com.fiap.endereco.model;

import jakarta.persistence.*;

public class Estado {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_estado"
    )
    @SequenceGenerator(
            name = "seq_estado",
            sequenceName = "seq_estado",
            allocationSize = 1
    )
    @Column(name = "id_estado")
    private Long id;

    @Column(name = "nome_estado")
    private String nome;

    @Column(name = "sigla_estado")
    private String sigla;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "id_pais",
            referencedColumnName = "id_pais",
            foreignKey = @ForeignKey(
                    name = "fk_estado_pais",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Pais pais;

    public Estado() {}

    public Estado(Long id, String nome, String sigla, Pais pais) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.pais = pais;
    }

    public Estado(String nome, String sigla, Pais pais) {
        this.nome = nome;
        this.sigla = sigla;
        this.pais = pais;
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

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", pais=" + pais +
                '}';
    }
}
