package br.com.fiap;

import br.com.fiap.conta.model.Agencia;
import br.com.fiap.conta.model.Conta;
import br.com.fiap.conta.model.ContaCorrente;
import br.com.fiap.conta.model.ContaPoupanca;
import br.com.fiap.pessoa.model.PF;
import br.com.fiap.pessoa.model.PJ;
import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Arrays;
import java.util.List;

public class Main {
    final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("maria-db");
    final static EntityManager MANAGER = FACTORY.createEntityManager();

    public static void main(String[] args) {
        PF pf = new PF();
        pf.setNome("Benefrancis do Nascimento");
        pf.setNascimento(LocalDate.of(1977, 3, 8));
        pf.setCPF("123.123.123-10");
        pf.setRG("11.111.111-X");

        PJ pj = new PJ();
        pj.setCNPJ("123.123.123-10");
        pj.setNome("Super Lojas Benezinho");
        pj.setNascimento(LocalDate.now().minusYears(3));
        pj.setInscricaoEstadual("12345678910");

        Agencia agPaulista = new Agencia();
        agPaulista.setNumero(1);

        ContaCorrente ccPF = new ContaCorrente();
        ccPF.setLimite(1000);
        ccPF.setSaldo(new BigDecimal("30000.00"));
        ccPF.setTitular(pf);
        ccPF.setNumero(8818);
        ccPF.setAgencia(agPaulista);

        ContaPoupanca cpPF = new ContaPoupanca();
        cpPF.setAniversario(MonthDay.now().getDayOfMonth());
        cpPF.setAgencia(agPaulista);
        cpPF.setSaldo(new BigDecimal("1000000.00"));
        cpPF.setNumero(1008818);
        cpPF.setTitular(pf);

        ContaCorrente ccPJ = new ContaCorrente();
        ccPJ.setSaldo(new BigDecimal("35000000.00"));
        ccPJ.setTitular(pj);
        ccPJ.setAgencia(agPaulista);
        ccPJ.setNumero(8819);
        ccPJ.setLimite(1000000);

        MANAGER.getTransaction().begin();
        List<Pessoa> pessoas = Arrays.asList(pf, pj);
        List<Conta> contas = Arrays.asList(ccPF, cpPF, ccPJ);
        pessoas.forEach(MANAGER::persist);
        contas.forEach(MANAGER::persist);
        MANAGER.getTransaction().commit();

        MANAGER.close();
        FACTORY.close();

        contas.forEach(System.out::println);
    }
}
