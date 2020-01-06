package com.iza.enem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iza.enem.model.Candidato;

@Repository
public interface CandidatoRepository extends CrudRepository<Candidato, Integer>{


}
