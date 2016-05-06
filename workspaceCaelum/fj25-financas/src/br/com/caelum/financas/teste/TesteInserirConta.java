package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteInserirConta {
	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		
		EntityManager manager = null;
		try {
			manager = new  JPAUtil().getEntityManager();
			ContaDao contaDao = new ContaDao(manager);
			Conta conta = new Conta("Wellington", "11", "58092-9", "237");
			manager.getTransaction().begin();
			contaDao.adiciona(conta);
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
