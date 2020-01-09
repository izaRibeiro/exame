package com.iza.enem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iza.enem.dto.CandidatoDTO;
import com.iza.enem.dto.ExameDTO;
import com.iza.enem.model.Exame;
import com.iza.enem.repository.ExameRepository;

@Service
public class ExameService {
    private final ExameRepository exameRepository;

    @Autowired
    public ExameService(ExameRepository exameRepository) {
        this.exameRepository = exameRepository;
    }

    public Exame salvar(ExameDTO exame) {
    	validarFormulario(exame);
        return exameRepository.save(exame.converterParaEntidade());
    }
    
	public Iterable<ExameDTO> buscarTodos() {
		return exameRepository.buscarTodos();
	}
	
	public Exame buscar(Integer id) {
		return exameRepository.findById(id).orElse(null);
	}
	
	public void excluir(Integer id) {
		exameRepository.deleteById(id);;		
	}
	
    public Exame editar(ExameDTO exame) {
        return exameRepository.save(exame.converterParaEntidade());
    }
    
	public void validarFormulario(ExameDTO exame) throws RuntimeException{
		if(exame.getVagas() == null || exame.getNome() == null) {
			throw new RuntimeException("Os campos não podem ser nulos");
		}
	}
	
}
