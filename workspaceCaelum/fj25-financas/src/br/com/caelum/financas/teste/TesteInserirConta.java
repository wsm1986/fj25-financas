package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TesteInserirConta {
	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("controlefinancas");
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();

			Conta conta = new Conta("Wellington", "1221", "58092-9", "237");
			manager.getTransaction().begin();
			manager.persist(conta);
			manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			manager.close();
			long fim = System.currentTimeMillis();
			System.out.println("Executado em: " + (fim - inicio)+ "ms");
		}
	}
}
