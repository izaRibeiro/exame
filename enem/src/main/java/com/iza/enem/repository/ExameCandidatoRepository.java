package com.iza.enem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iza.enem.dto.ExameCandidatoDTO;
import com.iza.enem.model.ExameCandidato;
import com.iza.enem.model.ExameCandidatoId;

@Repository
public interface ExameCandidatoRepository extends CrudRepository<ExameCandidato, ExameCandidatoId>{


	@Query("SELECT new com.iza.enem.dto.ExameCandidatoDTO(ec.id.exame, ec.id.candidato, ec.nota, e.nome, c.nome) "
			+ "FROM ExameCandidato ec "
			+ "JOIN Exame e ON e.id = ec.id.exame "
			+ "JOIN Candidato c ON c.id = ec.id.candidato")
	Iterable<ExameCandidatoDTO> buscarTodos();
}
