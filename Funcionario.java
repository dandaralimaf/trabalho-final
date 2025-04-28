package org.serratec.trabalho.modelos;

public class Funcionario extends Pessoa implements GerarRelatorio {
	protected Cargo cargo;

	public Funcionario(String nome, String cpf, String senha, Cargo cargo) {
		super(nome, cpf, senha);
		this.cargo = cargo;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	@Override
	public void gerar() {
		
		
	}

	@Override
	public void adicionarPersonal(Personal personal, Aluno aluno1) {
		// TODO Auto-generated method stub
		
	}

	
	
}
