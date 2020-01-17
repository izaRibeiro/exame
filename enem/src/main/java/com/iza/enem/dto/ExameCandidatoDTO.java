package com.iza.enem.dto;


import com.iza.enem.model.ExameCandidato;
import com.iza.enem.model.ExameCandidatoId;

public class ExameCandidatoDTO {

	private Double nota;

	private Integer candidato;
	
	private Integer exame;
	
	private String nomeExame;
	
	private String nomeCandidato;
	
	public ExameCandidatoDTO() {
	}

	public ExameCandidatoDTO(Integer exame,Integer candidato, Double nota, String nomeExame, String nomeCandidato) {
		super();
		this.nota = nota;
		this.candidato = candidato;
		this.exame = exame;
		this.nomeExame = nomeExame;
		this.nomeCandidato = nomeCandidato;
	}
	
	public ExameCandidatoDTO(Integer exame,Integer candidato, Double nota) {
		super();
		this.nota = nota;
		this.candidato = candidato;
		this.exame = exame;
	}


	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	
	
	public Integer getCandidato() {
		return candidato;
	}

	public void setCandidato(Integer candidato) {
		this.candidato = candidato;
	}

	public Integer getExame() {
		return exame;
	}

	public void setExame(Integer exame) {
		this.exame = exame;
	}

	
	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	public String getNomeCandidato() {
		return nomeCandidato;
	}

	public void setNomeCandidato(String nomeCandidato) {
		this.nomeCandidato = nomeCandidato;
	}

	public ExameCandidato converterParaEntidade() {
		return new ExameCandidato(this.nota, (new ExameCandidatoId(this.exame, this.candidato)));
	}
	
}

