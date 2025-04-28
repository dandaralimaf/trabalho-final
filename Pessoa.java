package org.serratec.trabalho.modelos;

public abstract class Pessoa {
	protected String nome;
	protected String cpf;
	protected String senha;
	
	public Pessoa(String nome, String cpf, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "\nNome: " + nome + "\nCPF: " + cpf;
	}
	
	public abstract void adicionarPersonal(Personal personal, Aluno aluno);
	
	
	
}
