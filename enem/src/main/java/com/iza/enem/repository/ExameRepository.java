package com.iza.enem.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.iza.enem.model.Exame;

@Repository
public interface ExameRepository extends CrudRepository<Exame, Integer>{

}
