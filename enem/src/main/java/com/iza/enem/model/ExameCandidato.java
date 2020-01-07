package com.iza.enem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.iza.enem.dto.ExameCandidatoDTO;

@Entity
public class ExameCandidato implements Serializable{
	@EmbeddedId
	private ExameCandidatoId id;
	
	@Column(name = "NOTA_CANDIDATO")
	private Double nota;
	
	/*@Id
	@ManyToOne
	@JoinColumn(name = "ID_CANDIDATO")
	private Candidato candidato;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "ID_EXAME")
	private Exame exame;*/
	
	public ExameCandidato() {
	}

	public ExameCandidato(Double nota) {
		super();
		this.nota = nota;
	}

	public ExameCandidato(Double nota, ExameCandidatoId exameCandidatoId) {
		super();
		this.nota = nota;
		this.id = exameCandidatoId;
	}


	

	public Double getNota() {
		return nota;
	}

	public void setNota(Double nota) {
		this.nota = nota;
	}
	
	public ExameCandidatoDTO converterParaDTO() {
		return new ExameCandidatoDTO(this.id.getCandidato(), this.id.getExame(), this.nota);
	}

	public ExameCandidatoId getId() {
		return id;
	}

	public void setId(ExameCandidatoId id) {
		this.id = id;
	}
	
	
}
