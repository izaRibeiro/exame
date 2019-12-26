package com.iza.enem.dto;

import com.iza.enem.model.Candidato;
import com.iza.enem.model.Exame;
import com.iza.enem.service.CandidatoService;


public class CandidatoDTO {
	private Integer idCandidato;
	private String nome;
	private String cidade;
	
	private Integer idexame;
	
	public Candidato transformaParaObjeto() {
		return new Candidato(idCandidato, nome, cidade, idexame);
	}

	public Integer getIdCandidato() {
		return idCandidato;
	}

	public void setIdCandidato(Integer idCandidato) {
		this.idCandidato = idCandidato;
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
	
}
