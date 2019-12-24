package com.iza.enem.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;





@Entity
public class Candidato implements Serializable{
	
	private static final int serialVersionUID = 1;
	
	@Id
	@Column(name = "IDCANDIDATO")
	//@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int idCandidato;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "CIDADE")
	private String cidade;
	
	
	/*@ManyToOne
	//private Exame exame_idexame;
	//private String exame_idexame;
	@JoinColumn(name = "EXAME_IDEXAME")
	@Autowired
	private Exame exame_idexame;*/
	
	@ManyToMany
	@JoinTable(name = "exame_has_candidato",
	joinColumns = @JoinColumn(name = "Candidato_idCandidato"),
	inverseJoinColumns = @JoinColumn(name = "Exame_idExame"))
	private List<Exame> exames;
	
	public Candidato() {
	}
	
	public Candidato(int idCandidato, String nome, String cidade) {
		this.idCandidato = idCandidato;
		this.nome = nome;
		this.cidade = cidade;
		//this.exames.add(exame);
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

	public int getIdCandidato() {
		return idCandidato;
	}
	public void setIdCandidato(int idCandidato) {
		this.idCandidato = idCandidato;
	}

	/*public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames.add(exames);
	}*/

	/*public String getExame_idexame() {
		return exame_idexame;
	}

	public void setExame_idexame(String exame_idexame) {
		this.exame_idexame = exame_idexame;
	}*/

	/*public Exame getExame_idexame() {
		return exame_idexame;
	}

	public void setExame_idexame(Exame exame_idexame) {
		this.exame_idexame = exame_idexame;
	}*/


	
}
