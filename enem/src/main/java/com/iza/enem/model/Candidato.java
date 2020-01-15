package com.iza.enem.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.iza.enem.dto.CandidatoDTO;

@Entity
@Table(name = "Candidato")
public class Candidato implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "NOME")
	private String nome;

	@Column(name = "CIDADE")
	private String cidade;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "SENHA")
	private String senha;

	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinTable(name = "exame_candidato", 
		joinColumns = @JoinColumn(name = "ID_CANDIDATO", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "ID_EXAME", referencedColumnName = "ID"))
	@JsonBackReference
	private List<Exame> exames;
	
	public Candidato() {
	}

	public Candidato(Integer id, String nome, String cidade, Integer idexame, String email, String senha) {
		this.nome = nome;
		this.cidade = cidade;
		this.id = id;
		this.email = email;
		this.senha = senha;
		
	}
	
	public Candidato(Integer id, String nome, String cidade, Integer idexame) {
		this.nome = nome;
		this.cidade = cidade;
		this.id = id;
	}
	

	
	public Candidato(Integer id, String nome, String cidade) {
		this.nome = nome;
		this.cidade = cidade;
	}

	public Candidato(Integer idCandidato) {
		super();
		this.id = idCandidato;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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

	public CandidatoDTO converterParaDTO() {
		CandidatoDTO candidatoDTO = new CandidatoDTO();
		candidatoDTO.setCidade(this.cidade);
		candidatoDTO.setNome(this.nome);
		candidatoDTO.setId(this.id);
		candidatoDTO.setEmail(this.email);
		candidatoDTO.setSenha(this.senha);
		return candidatoDTO;
	}
	
	
}
