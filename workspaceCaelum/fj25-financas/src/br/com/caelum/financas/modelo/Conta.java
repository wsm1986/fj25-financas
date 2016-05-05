package br.com.caelum.financas.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Conta {

	@Id
	@GeneratedValue
	private Integer id;

	public Conta(String titulas, String agencia, String numero, String banco) {
		super();
		this.titulas = titulas;
		this.agencia = agencia;
		this.numero = numero;
		this.banco = banco;
	}

	private String titulas;
	private String agencia;
	private String numero;
	private String banco;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulas() {
		return titulas;
	}

	public void setTitulas(String titulas) {
		this.titulas = titulas;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}
}
