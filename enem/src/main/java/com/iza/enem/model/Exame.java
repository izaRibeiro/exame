package com.iza.enem.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;

@Entity
public class Exame {
	
	
	@Id
	@Column(name = "IDEXAME")
	private int idexame;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "VAGAS")
	private int vagas;

	/*@OneToMany
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<Candidato> candidatos;*/
	
	@ManyToMany(mappedBy = "exames")
	private List<Candidato> candidatos;
	
	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public int getIdexame() {
		return idexame;
	}

	public void setIdexame(int idexame) {
		this.idexame = idexame;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	/*public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}*/
	
	
}
