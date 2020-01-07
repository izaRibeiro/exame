package com.iza.enem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.iza.enem.model.ExameCandidatoId;
import com.iza.enem.dto.ExameCandidatoDTO;
import com.iza.enem.model.ExameCandidato;
import com.iza.enem.repository.ExameCandidatoRepository;

@Service
public class ExameCandidatoService {
	@Autowired
	private ExameCandidatoRepository exameCandidatoRepository;


	public Iterable<ExameCandidato> buscarTodos() {
		return exameCandidatoRepository.findAll();
	}

	public ExameCandidatoDTO buscar(ExameCandidatoId exameCandidatoId) {
		return exameCandidatoRepository.findById(exameCandidatoId).get().converterParaDTO();
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

	public void deletar(ExameCandidatoId exameCandidatoId) {
		exameCandidatoRepository.deleteById(exameCandidatoId);
	}

}
