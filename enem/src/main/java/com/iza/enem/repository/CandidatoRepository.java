package com.iza.enem.repository;

import org.springframework.data.repository.CrudRepository;

import com.iza.enem.dto.CandidatoDTO;
import com.iza.enem.model.Candidato;

public interface CandidatoRepository extends CrudRepository<Candidato, String>{


}
