package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteSalvaMovimentacaoComConta {

	public static void main(String[] args) {
		EntityManager manager = new JPAUtil().getEntityManager();
		try {
			manager.getTransaction().begin();

			Conta conta = new Conta("Gabriel", "1122", "9999", "Bradesco");
			manager.persist(conta);
			Movimentacao movimentacao = new Movimentacao();
			movimentacao.setConta(conta);
			movimentacao.setData(Calendar.getInstance());
			movimentacao.setDescricao("Conta de Luz");
			movimentacao.setValor(new BigDecimal(100));
			movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);

			manager.persist(movimentacao);
			manager.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			manager.close();
		}
	}

}
