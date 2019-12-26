package com.iza.enem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iza.enem.dto.CandidatoDTO;
import com.iza.enem.model.Candidato;
import com.iza.enem.repository.CandidatoRepository;

@Service
public class CandidatoService {

    private final CandidatoRepository candidatoRepository;

    @Autowired
    public CandidatoService(CandidatoRepository candidatoRepository) {
        this.candidatoRepository = candidatoRepository;
    }

    public Candidato salvar(CandidatoDTO candidato) {
        return candidatoRepository.save(candidato.transformaParaObjeto());
    }
    
	public Iterable<Candidato> buscarTodos() {
		return candidatoRepository.findAll();
	}

	public Candidato buscar(Integer id) {
		return candidatoRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		candidatoRepository.deleteById(id);;		
	}
}
