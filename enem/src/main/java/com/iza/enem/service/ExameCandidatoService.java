package com.iza.enem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iza.enem.model.ExameCandidatoId;
import com.iza.enem.dto.ExameCandidatoDTO;
import com.iza.enem.model.ExameCandidato;
import com.iza.enem.repository.ExameCandidatoRepository;

@Service
public class ExameCandidatoService {
	@Autowired
	private ExameCandidatoRepository exameCandidatoRepository;


	public Iterable<ExameCandidato> buscar() {
		return exameCandidatoRepository.findAll();
	}

	/*public Iterable<ExameCandidato> buscarTodosPorCandidato(Long candidatoId) {
		return exameCandidatoRepository.findByInscricaoKeyCandidatoId(candidatoId);
	}
	
	public Iterable<ExameCandidato> buscarTodosPorExame(Long exameId) {
		return exameCandidatoRepository.findByInscricaoKeyExameId(exameId);
	}*/
	

	
	public ExameCandidato salvar(ExameCandidatoDTO exameCandidatoDTO) {
		return exameCandidatoRepository.save(exameCandidatoDTO.converterParaEntidade());
	}

	public void deletar(ExameCandidatoId inscricaoKey) {
		exameCandidatoRepository.deleteById(inscricaoKey);
	}

}
