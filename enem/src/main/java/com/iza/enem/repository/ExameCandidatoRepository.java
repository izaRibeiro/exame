package com.iza.enem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iza.enem.model.ExameCandidato;
import com.iza.enem.model.ExameCandidatoId;

@Repository
public interface ExameCandidatoRepository extends CrudRepository<ExameCandidato, ExameCandidatoId>{


}
