package org.serratec.trabalho.modelos;

import java.time.LocalDate;

public class Avaliacao {
	public Aluno aluno;
	protected LocalDate data;	
	protected Personal personal;
	protected String descricao;
	
	@Override
	public String toString() {
		return "Avaliacao [aluno=" + aluno + ", data=" + data + ", personal=" + personal + ", descricao=" + descricao
				+ "]";
	}

	public Avaliacao(Aluno aluno, LocalDate data, Personal personal, String descricao) {
		this.aluno = aluno;
		this.data = data;
		this.personal = personal;
		this.descricao = descricao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Personal getPersonal() {
		return personal;
	}

	public void setPersonal(Personal personal) {
		this.personal = personal;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
}
