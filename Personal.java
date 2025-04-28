package org.serratec.trabalho.modelos;

public class Personal extends Pessoa {
	
	@Override
	public String toString() {
		return super.toString() + "\nEspecialidade: " + especialidade + "\nCREF: " + cref;
	}

	protected String especialidade;
	protected String cref;
	
	public Personal(String nome, String cpf, String senha, String especialidade, String cref) {
		super(nome, cpf, senha);
		this.especialidade = especialidade;
		this.cref = cref;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCref() {
		return cref;
		
	}

	public void setCref(String cref) {
		this.cref = cref;
	}

	@Override
	public void adicionarPersonal(Personal personal, Aluno aluno1) {
		
		
	}
	
	

}
