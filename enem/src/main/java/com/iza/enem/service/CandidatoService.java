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

	public void excluir(Integer id) {
		candidatoRepository.deleteById(id);
	}

	
	public Candidato editar(CandidatoDTO candidato) {
		return candidatoRepository.save(candidato.converterParaEntidade());
	}
	
	public void validarFormulario(CandidatoDTO candidato) throws RuntimeException{
		if(candidato.getCidade() == null || candidato.getNome() == null) {
			throw new RuntimeException("Os campos não podem ser nulos");
		}
	}
}
