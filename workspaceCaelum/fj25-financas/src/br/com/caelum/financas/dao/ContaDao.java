package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class ContaDao {
	private EntityManager manager;  

	public ContaDao(EntityManager manager) {
		this.manager = manager;
	}
	
	public ContaDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Conta busca(Integer id){
		return manager.find(Conta.class, id);
	}
	public List<Conta> lista(){
		return manager.createQuery("select c from Conta c").getResultList();	
	}
	
	public void adiciona(Conta conta){
		manager.persist(conta);
	}
	public void remover(Conta conta){
		manager.remove(conta);
	}
	
	
	
}
