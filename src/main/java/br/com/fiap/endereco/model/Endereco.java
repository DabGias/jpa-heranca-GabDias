package br.com.fiap.endereco.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_endereco")
public class Endereco {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_endereco"
    )
    @SequenceGenerator(
            name = "seq_endereco",
            sequenceName = "seq_endereco",
            allocationSize = 1
    )
    @Column(name = "id_endereco")
    private Long id;

    @Column(name = "logradouro_endereco")
    private String logradouro;

    @Column(name = "numero_endereco")
    private String numero;

    @Column(name = "complemento_endereco")
    private String complemento;

    @Column(name = "cep_endereco")
    private String CEP;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "id_cidade",
            referencedColumnName = "id_cidade",
            foreignKey = @ForeignKey(
                    name = "fk_endereco_cidade",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Cidade cidade;

    public Endereco() {}

    public Endereco(Long id, String logradouro, String numero, String complemento, String CEP, Cidade cidade) {
        this.id = id;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.CEP = CEP;
        this.cidade = cidade;
    }

    public Endereco(String logradouro, String numero, String complemento, String CEP, Cidade cidade) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.CEP = CEP;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", logradouro='" + logradouro + '\'' +
                ", numero='" + numero + '\'' +
                ", complemento='" + complemento + '\'' +
                ", CEP='" + CEP + '\'' +
                ", cidade=" + cidade +
                '}';
    }
}
