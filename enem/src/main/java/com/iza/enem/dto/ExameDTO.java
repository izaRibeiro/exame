package com.iza.enem.dto;

import com.iza.enem.model.Exame;

public class ExameDTO {
	private Integer id;
	private String nome;
	private Integer vagas;
	
	private Integer idCandidato;
	
	public Exame converterParaEntidade() {
		return new Exame(id, nome, vagas);
	}
	
	

	public ExameDTO(Integer idexame, String nome, Integer vagas) {
		super();
		this.id = idexame;
		this.nome = nome;
		this.vagas = vagas;
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



	public Integer getIdCandidato() {
		return idCandidato;
	}



	public void setIdCandidato(Integer idCandidato) {
		this.idCandidato = idCandidato;
	}




	
	
}
