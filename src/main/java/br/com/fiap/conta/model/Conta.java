package br.com.fiap.conta.model;

import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Conta {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "seq_conta"
    )
    @SequenceGenerator(
            name = "seq_conta",
            sequenceName = "seq_conta",
            allocationSize = 1
    )
    @Column(name = "id_conta")
    private Long id;

    @Column(name = "numero_conta")
    private int numero;

    @Column(name = "saldo_conta")
    private BigDecimal saldo;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "id_pessoa",
            referencedColumnName = "id_pessoa",
            foreignKey = @ForeignKey(
                    name = "fk_pessoa_conta"
            )
    )
    private Pessoa titular;

    @ManyToOne(
            fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            }
    )
    @JoinColumn(
            name = "id_agencia",
            referencedColumnName = "id_agencia",
            foreignKey = @ForeignKey(
                    name = "fk_tb_agencia"
            )
    )
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
