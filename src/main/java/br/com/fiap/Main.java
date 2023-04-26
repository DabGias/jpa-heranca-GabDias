package br.com.fiap;

import br.com.fiap.pessoa.model.PF;
import br.com.fiap.pessoa.model.PJ;
import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
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

        MANAGER.getTransaction().begin();
        List<Pessoa> pessoas = Arrays.asList(pf, pj);
        pessoas.forEach(MANAGER::persist);
        MANAGER.getTransaction().commit();

        MANAGER.close();
        FACTORY.close();
    }
}
