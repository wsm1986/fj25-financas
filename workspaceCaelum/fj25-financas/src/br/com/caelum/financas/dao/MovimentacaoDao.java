package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDao {
	private EntityManager manager;

	public Movimentacao busca(Integer id) {
		return manager.find(Movimentacao.class, id);
	}

	public List<Movimentacao> lista() {
		return manager.createQuery("select m from Movimentacao m").getResultList();
	}

	public MovimentacaoDao(EntityManager manager) {
		super();
		this.manager = manager;
	}

	public void adiciona(Movimentacao movimentacao) {
		manager.persist(movimentacao);
	}

	public void remover(Movimentacao movimentacao) {
		manager.remove(movimentacao);
	}
}
