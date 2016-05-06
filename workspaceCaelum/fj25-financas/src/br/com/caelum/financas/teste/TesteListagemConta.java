package br.com.caelum.financas.teste;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteListagemConta {

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();

		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			List<Conta> lista = new ArrayList<Conta>();
			ContaDao dao = new ContaDao(manager);
			lista = dao.lista();
			for (Conta conta : lista) {
				System.out.println(conta.getTitulas());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			manager.close();
			long fim = System.currentTimeMillis();
			System.out.println("Executado em: " + (fim - inicio) + "ms");
		}
	}
}
