package com.iza.enem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ForeignKey;

import ch.qos.logback.core.joran.spi.NoAutoStart;



@Entity
public class Candidato implements Serializable{
	
	private static final int serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int idCandidato;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CIDADE")
	private String cidade;
	
	@Column(name = "NOTA")
	private Double nota;
	
	/*@ManyToOne
	@JoinColumn(name = "exame")
	private Exame exame_idexame;*/
	private String exame_idexame;
	
	public Candidato() {
	}
	
	public Candidato(int idCandidato, String nome, String cidade, Double nota) {
		this.idCandidato = idCandidato;
		this.nome = nome;
		this.cidade = cidade;
		this.nota = nota;
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
	public Double getNota() {
		return nota;
	}
	public void setNota(Double nota) {
		this.nota = nota;
	}
	public int getIdCandidato() {
		return idCandidato;
	}
	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}

	public String getExame_idexame() {
		return exame_idexame;
	}

	public void setExame_idexame(String exame_idexame) {
		this.exame_idexame = exame_idexame;
	}

	/*public Exame getExame_idexame() {
		return exame_idexame;
	}

	public void setExame_idexame(Exame exame_idexame) {
		this.exame_idexame = exame_idexame;
	}*/


	
}
