package com.iza.enem.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;

@Entity
public class Exame {
	
	
	@Id
	private int idexame;
	
	private int vagas;

	@OneToMany
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Candidato> candidatos;
	
	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	/*public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}*/
	
	
}
