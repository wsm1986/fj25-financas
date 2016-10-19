package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.util.JPAUtil;

public class TestaAberturaConexoes {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 50; i++) {
			EntityManager manager = new JPAUtil().getEntityManager();
			manager.getTransaction().begin();
			System.out.println("Criando Entity Manager"+i);
		}
		Thread.sleep(30*1000);
	}
}
