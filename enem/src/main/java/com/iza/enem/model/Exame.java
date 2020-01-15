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
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "SENHA")
	private String senha;

	@ManyToMany(mappedBy = "exames")
	@JsonManagedReference
	private List<Candidato> candidatos;
	

	public Exame() {
	}

	public Exame(Integer idExame) {
		this.id = idExame;
	}
	
	public Exame(Integer id, String nome, Integer vagas, String email, String senha) {
		this.nome = nome;
		this.vagas = vagas;
		this.id = id;
		this.email = email;
		this.senha = senha;
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
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		return new ExameDTO(id, nome, vagas, email, senha);
	}
	
	
}
