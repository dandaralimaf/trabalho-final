package org.serratec.trabalho.modelos;

public class Cargo {
	protected String descricao;
	protected double salario;
	
	public Cargo(String descricao, double salario) {
		this.descricao = descricao;
		this.salario = salario;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
