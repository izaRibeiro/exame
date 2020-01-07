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


	public Iterable<ExameCandidatoDTO> buscarTodos() {
		return exameCandidatoRepository.buscarTodos();
	}

	public ExameCandidatoDTO buscar(ExameCandidatoId exameCandidatoId) {
		return exameCandidatoRepository.findById(exameCandidatoId).get().converterParaDTO();
	}
	
	public ExameCandidato salvar(ExameCandidatoDTO exameCandidatoDTO) {
		return exameCandidatoRepository.save(exameCandidatoDTO.converterParaEntidade());
	}
	
	public ExameCandidato editar(ExameCandidatoDTO exameCandidatoDTO) {
		return exameCandidatoRepository.save(exameCandidatoDTO.converterParaEntidade());
	}

	public void deletar(ExameCandidatoId exameCandidatoId) {
		exameCandidatoRepository.deleteById(exameCandidatoId);
	}

}
