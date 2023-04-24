package br.com.fiap;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("maria-db");
    final static EntityManager MANAGER = FACTORY.createEntityManager();

    public static void main(String[] args) {

    }
}
