package com.iza.enem.dto;


import com.iza.enem.model.ExameCandidato;
import com.iza.enem.model.ExameCandidatoId;

public class ExameCandidatoDTO {

	private Double nota;

	private Integer candidato;
	
	private Integer exame;
	
	public ExameCandidatoDTO() {
	}

	public ExameCandidatoDTO(Integer candidato, Integer exame, Double nota) {
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

	public ExameCandidato converterParaEntidade() {
		return new ExameCandidato(this.nota, (new ExameCandidatoId(this.candidato, this.exame)));
	}
	
}

