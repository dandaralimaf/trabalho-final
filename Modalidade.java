package org.serratec.trabalho.modelos;

public class Modalidade {
	
	@Override
	public String toString() {
		return "\nModalidade: "+ descricao + "\nValor: " + valor;
	}

	protected String descricao;
	protected double valor;
	
	public Modalidade(String descricao, double valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
}

