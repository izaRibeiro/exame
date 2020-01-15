package com.iza.enem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.iza.enem.dto.CandidatoDTO;
import com.iza.enem.model.Candidato;
import com.iza.enem.repository.CandidatoRepository;

@Service
public class CandidatoService {

	@Autowired
	private CandidatoRepository candidatoRepository;

	public Candidato salvar(CandidatoDTO candidatoDTO) {
			validarFormulario(candidatoDTO);			
			Candidato candidato = candidatoDTO.converterParaEntidade();

			return candidatoRepository.save(candidato);

		

	}

	public Iterable<CandidatoDTO> buscarTodos() {
		return candidatoRepository.buscarTodos();
	}

	public Candidato buscar(Integer id) {
		return candidatoRepository.findById(id).orElse(null);
	}
	
	public Candidato buscarPorEmail(String email) {
		return candidatoRepository.findByEmail(email);
	}
	
	public Iterable<Candidato> buscarPorSenha(String senha) {
		return candidatoRepository.findBySenha(senha);
	}


	public void excluir(Integer id) {
		candidatoRepository.deleteById(id);
	}

	
	public Candidato editar(CandidatoDTO candidato) {
		return candidatoRepository.save(candidato.converterParaEntidade());
	}
	
	public void logar(String login, String senha) {
		CandidatoDTO candidato = new CandidatoDTO();
		candidato.setEmail(login);
		candidato.setSenha(senha);
		validarLogin(candidato);
	}
	
	public void validarFormulario(CandidatoDTO candidato) throws RuntimeException{
		if(candidato.getCidade() == null || candidato.getNome() == null) {
			throw new RuntimeException("Os campos não podem ser nulos");
		}
		if(candidatoRepository.findByEmail(candidato.getEmail()) != null) {
			throw new RuntimeException("O e-mail solicitado já existe. Por favor, insira outro e-mail");
		}
		
	}
	
	public boolean validarLogin(CandidatoDTO candidato) {
		if(candidatoRepository.findByEmail(candidato.getEmail()) != null
			&& candidatoRepository.findBySenha(candidato.getSenha()) != null) {
			return true;
		}else {
			return false;
		}
	}
}
