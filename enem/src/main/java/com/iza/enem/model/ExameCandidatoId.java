package com.iza.enem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExameCandidatoId implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "ID_CANDIDATO")
	private Integer candidato;
	@Column(name = "ID_EXAME")
	private Integer exame;

	
	public ExameCandidatoId() {
	}


	
	public ExameCandidatoId(Integer candidato, Integer exame) {
		super();
		this.candidato = candidato;
		this.exame = exame;
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
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((candidato == null) ? 0 : candidato.hashCode());
		result = prime * result + ((exame == null) ? 0 : exame.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExameCandidatoId other = (ExameCandidatoId ) obj;
		if (candidato == null) {
			if (other.candidato != null)
				return false;
		} else if (!candidato.equals(other.candidato))
			return false;
		if (exame == null) {
			if (other.exame != null)
				return false;
		} else if (!exame.equals(other.exame))
			return false;
		return true;
	}
	
	


}
