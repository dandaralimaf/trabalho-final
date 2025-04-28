package org.serratec.trabalho.modelos;

import java.time.LocalDate;

public class Aluno extends Pessoa {
	protected LocalDate dataDeMatricula;
	protected Plano plano;
	protected Personal personalContratado;
	protected Modalidade modalidade;
	
	public Aluno(String nome, String cpf, String senha, LocalDate dataDeMatricula, Plano plano,
			Modalidade modalidade) {
		super(nome, cpf, senha);
		this.dataDeMatricula = dataDeMatricula;
		this.plano = plano;
		this.modalidade = modalidade;
	}

	public LocalDate getDataDeMatricula() {
		return dataDeMatricula;
	}

	public void setDataDeMatricula(LocalDate dataDeMatricula) {
		this.dataDeMatricula = dataDeMatricula;
	}

	public Plano getPlano() {
		return plano;
	}

	public void setPlano(Plano plano) {
		this.plano = plano;
	}

	public Personal getPersonalContratado() {
		return personalContratado;
	}

	public void setPersonalContratado(Personal contratado) {
		this.personalContratado = contratado;
	}

	public Modalidade getModalidade() {
		return modalidade;
	}

	public void setModalidade(Modalidade modalidade) {
		this.modalidade = modalidade;
	}

	@Override
	public String toString() {
		//if(Personal.getCref() == null) {
			
		//}
		return super.toString() +  "\nData de matrícula: " + dataDeMatricula + "\nPlano: " + plano + "\nPersonal: " + personalContratado + modalidade;
	}
	
	 {
			
	
	
	
}

	@Override
	public void adicionarPersonal(Personal personal1, Aluno aluno1) {
		aluno1.setPersonalContratado(personal1);
		System.out.println(aluno1 + "\n");
	}
	
	
	public void contratarPersonal() {
		
	}

}

