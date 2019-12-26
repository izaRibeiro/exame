package com.iza.enem.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import org.hibernate.annotations.Cascade;

@Entity(name = "Exame")
public class Exame {
	
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idexame;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "VAGAS")
	private Integer vagas;

	
	@ManyToMany(mappedBy = "exames")
	private List<Candidato> candidatos;
	
	
	public Exame() {
	}
	
	public Exame(Integer idExame) {
		this.idexame = idexame;
		//this.candidatos = new ArrayList<Candidato>();
	}

	public Exame(Integer idexame, String nome,Integer vagas, Integer idCandidato) {
	//	this.candidatos = new ArrayList<Candidato>();
		this.idexame = idexame;
		this.nome = nome;
		this.vagas = vagas;
		Candidato candidato = new Candidato(idCandidato); 
		//this.candidatos.add(candidato);
	}

	
	public Integer getIdexame() {
		return idexame;
	}

	public void setIdexame(Integer idexame) {
		this.idexame = idexame;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
		this.vagas = vagas;
	}

	
}
