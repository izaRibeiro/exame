package com.iza.enem.model;

import java.io.Serializable;
import java.util.ArrayList;
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

	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinTable(name = "exame_candidato", 
		joinColumns = @JoinColumn(name = "ID_CANDIDATO", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "ID_EXAME", referencedColumnName = "ID"))
	@JsonBackReference
	private List<Exame> exames;

	public Candidato() {
	}

	public Candidato(Integer id, String nome, String cidade, Integer idexame) {
		this.exames = new ArrayList<Exame>();
		this.nome = nome;
		this.cidade = cidade;
		this.id = id;
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

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}

	public CandidatoDTO converterParaDTO() {
		CandidatoDTO candidatoDTO = new CandidatoDTO();
		candidatoDTO.setCidade(this.cidade);
		candidatoDTO.setNome(this.nome);
		candidatoDTO.setIdCandidato(this.id);
		return candidatoDTO;
	}
}
