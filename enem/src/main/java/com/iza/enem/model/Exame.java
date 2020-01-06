package com.iza.enem.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.iza.enem.dto.ExameDTO;

@Entity
@Table(name = "Exame")
public class Exame {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "VAGAS")
	private Integer vagas;

	@ManyToMany(mappedBy = "exames")
	@JsonManagedReference
	private List<Candidato> candidatos;
	
	/*@OneToMany(mappedBy = "exame", cascade = CascadeType.ALL)
	private List<ExameCandidato> exameCandidato;*/

	public Exame() {
	}

	public Exame(Integer idExame) {
		this.id = idExame;
	//	this.candidatos = new ArrayList<Candidato>();
	}

	public Exame(Integer id, String nome, Integer vagas) {
		this.nome = nome;
		this.vagas = vagas;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public ExameDTO converterParaDTO() {
		return new ExameDTO(id, nome, vagas);
	}
}
