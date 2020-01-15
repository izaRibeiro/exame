package com.iza.enem.dto;

import com.iza.enem.model.Candidato;


public class CandidatoDTO {
	private Integer id;
	private String nome;
	private String cidade;
	private String email;
	private String senha;
	
	private Integer idexame;
	
	public CandidatoDTO() {

	}
	
	public CandidatoDTO(Integer id, String nome, String cidade, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
		this.email = email;
		this.senha = senha;
	}


	public Candidato converterParaEntidade() {
		return new Candidato(id, nome, cidade, idexame, email, senha);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer idCandidato) {
		this.id = idCandidato;
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

	public Integer getIdexame() {
		return idexame;
	}

	public void setIdexame(Integer idexame) {
		this.idexame = idexame;
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
	
	
	
}
