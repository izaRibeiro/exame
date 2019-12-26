package com.iza.enem.dto;

import com.iza.enem.model.Exame;

public class ExameDTO {
	private Integer idexame;
	private String nome;
	private Integer vagas;
	
	private Integer idCandidato;
	
	public Exame transformaParaObjeto() {
		return new Exame(idexame, nome, vagas, idCandidato);
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

	public Integer getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Integer idCandidato) {
		this.idCandidato = idCandidato;
	}
	
	
}