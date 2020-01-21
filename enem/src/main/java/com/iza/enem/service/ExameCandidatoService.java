package com.iza.enem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iza.enem.dto.ExameCandidatoDTO;
import com.iza.enem.model.ExameCandidato;
import com.iza.enem.model.ExameCandidatoId;
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
		validarFormulario(exameCandidatoDTO);
		return exameCandidatoRepository.save(exameCandidatoDTO.converterParaEntidade());
	}
	
	public ExameCandidato editar(ExameCandidatoDTO exameCandidatoDTO) {
		return exameCandidatoRepository.save(exameCandidatoDTO.converterParaEntidade());
	}

	public void deletar(ExameCandidatoId exameCandidatoId) {
		exameCandidatoRepository.deleteById(exameCandidatoId);
	}

	public void validarFormulario(ExameCandidatoDTO exameCandidato) throws RuntimeException{
		if(exameCandidato.getCandidato() == null || exameCandidato.getExame() == null) {
			throw new RuntimeException("Os campos não podem ser nulos");
		}
		if(exameCandidato.getNota() != null) {
			if(exameCandidato.getNota() < 0 || exameCandidato.getNota() > 100) {
				throw new RuntimeException("A nota deve obrigatóriamente estar entre 0 e 100");
			}
		}
	}
	

	
}
