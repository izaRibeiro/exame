package com.iza.enem.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iza.enem.dto.ExameCandidatoDTO;
import com.iza.enem.model.ExameCandidato;
import com.iza.enem.model.ExameCandidatoId;

@Repository
public interface ExameCandidatoRepository extends CrudRepository<ExameCandidato, ExameCandidatoId>{

	@Query("SELECT new com.iza.enem.dto.ExameCandidatoDTO(ec.id.candidato, ec.id.exame, ec.nota) FROM ExameCandidato ec ")
	Iterable<ExameCandidatoDTO> buscarTodos();
}
