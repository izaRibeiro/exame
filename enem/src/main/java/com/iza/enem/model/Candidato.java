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
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Table;
import org.springframework.beans.factory.annotation.Autowired;





@Entity(name = "Candidato")
public class Candidato implements Serializable{
	
	private static final int serialVersionUID = 1;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Integer idCandidato;
	
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
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "exame_candidato" ,
	joinColumns = @JoinColumn(name = "Candidato_idCandidato", referencedColumnName = "ID"),
	inverseJoinColumns = @JoinColumn(name = "Exame_idExame", referencedColumnName = "ID"))
	private List<Exame> exames;
	
	public Candidato() {
	}
	
	public Candidato(int idCandidato, String nome, String cidade, Integer idexame) {
		this.exames = new ArrayList<Exame>();
		Exame exame = new Exame(idexame); 
		//exame.getCandidatos().add(this);
		this.idCandidato = idCandidato;
		this.nome = nome;
		this.cidade = cidade;
		this.exames.add(exame);
	}
	
	public Candidato(Integer idCandidato) {
		super();
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

	public int getIdCandidato() {
		return idCandidato;
	}
	public void setIdCandidato(Integer idCandidato) {
		this.idCandidato = idCandidato;
	}

    public void addExame(Exame exame) {
        exames.add(exame);
        exame.getIdexame();
    }
 
    public void removeExame(Exame exame) {
        exames.remove(exame);
        exame.getIdexame();
    }


	
}
