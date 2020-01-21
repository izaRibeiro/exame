package com.iza.enem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    	try {
        	validarFormulario(exame);
            return exameRepository.save(exame.converterParaEntidade());
    	}catch(Exception e) {
    		throw new RuntimeException("Algum dos valores inseridos não é válido. Por favor, verifique as entradas");
    	}
    }
    
	public Iterable<ExameDTO> buscarTodos() {
		return exameRepository.buscarTodos();
	}
	
	public Exame buscar(Integer id) {
		return exameRepository.findById(id).orElse(null);
	}
	
	public Exame buscarPorEmail(String email) {
		return exameRepository.findByEmail(email);
	}
	
	public Iterable<Exame> buscarPorSenha(String senha) {
		return exameRepository.findBySenha(senha);
	}

	public void excluir(Integer id) {
		exameRepository.deleteById(id);;		
	}
	
    public Exame editar(ExameDTO exame) {
        return exameRepository.save(exame.converterParaEntidade());
    }
    
	public void logar(String login, String senha) {
		ExameDTO exame = new ExameDTO();
		exame.setEmail(login);
		exame.setSenha(senha);
		validarLogin(exame);
	}
	
	public void validarFormulario(ExameDTO exame) throws RuntimeException{
		if(exame.getVagas() == null || exame.getNome() == null) {
			throw new RuntimeException("Os campos não podem ser nulos");
		}
		if(exameRepository.findByEmail(exame.getEmail()) != null) {
			throw new RuntimeException("O e-mail solicitado já existe. Por favor, insira outro e-mail");
		}
	}
	
	public boolean validarLogin(ExameDTO exame) {
		if(exameRepository.findByEmail(exame.getEmail()) != null
			&& exameRepository.findBySenha(exame.getSenha()) != null) {
			return true;
		}else {
			return false;
		}
	}
	
}
