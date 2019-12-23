package com.iza.enem.dto;

import com.iza.enem.model.Candidato;
import com.iza.enem.service.CandidatoService;


public class CandidatoDTO {
	private int idCandidato;
	private String nome;
	private String cidade;
	private Double nota;
	
	public Candidato transformaParaObjeto() {
		return new Candidato(idCandidato, nome, cidade, nota);
	}
}
