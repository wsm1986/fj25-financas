package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteRemoveConta {
	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();

		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			ContaDao dao = new ContaDao(manager);
			manager.getTransaction().begin();
			Conta conta = dao.busca(1);
			dao.remover(conta);
			manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			manager.close();
			long fim = System.currentTimeMillis();
			System.out.println("Executado em: " + (fim - inicio) + "ms");
		}
	}
}
