package com.iza.enem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iza.enem.dto.ExameDTO;
import com.iza.enem.model.Candidato;
import com.iza.enem.model.Exame;

@Repository
public interface ExameRepository extends CrudRepository<Exame, Integer>{

	@Query("SELECT new com.iza.enem.dto.ExameDTO(e.id, e.nome, e.vagas, e.email, e.senha) FROM Exame e")
	Iterable<ExameDTO> buscarTodos();
	
	Exame findByEmail(String email);
	
	Iterable<Exame> findBySenha(String senha);

}
