package com.iza.enem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iza.enem.model.Candidato;
import com.iza.enem.model.Exame;
import com.iza.enem.repository.CandidatoRepository;
import com.iza.enem.repository.ExameRepository;

@Service
public class ExameService {
    private final ExameRepository exameRepository;

    @Autowired
    public ExameService(ExameRepository exameRepository) {
        this.exameRepository = exameRepository;
    }

    public Exame salvar(Exame exame) {
        return exameRepository.save(exame);
    }
    
	public Iterable<Exame> buscarTodos() {
		return exameRepository.findAll();
	}
	
	public Exame buscar(String id) {
		return exameRepository.findById(id).orElse(null);
	}
}
