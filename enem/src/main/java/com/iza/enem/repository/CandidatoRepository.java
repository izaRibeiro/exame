package com.iza.enem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iza.enem.dto.CandidatoDTO;
import com.iza.enem.model.Candidato;

@Repository
public interface CandidatoRepository extends CrudRepository<Candidato, Integer>{

	@Query("SELECT new com.iza.enem.dto.CandidatoDTO(c.id, c.nome, c.cidade, c.email, c.senha) FROM Candidato c")
	Iterable<CandidatoDTO> buscarTodos();

	Candidato findByEmail(String email);
	
	Iterable<Candidato> findBySenha(String senha);
}