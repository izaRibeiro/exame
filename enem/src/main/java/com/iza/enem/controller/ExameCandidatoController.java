package com.iza.enem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iza.enem.dto.ExameCandidatoDTO;
import com.iza.enem.model.ExameCandidato;
import com.iza.enem.model.ExameCandidatoId;
import com.iza.enem.service.ExameCandidatoService;

@RequestMapping("/exameCandidato")
@RestController
public class ExameCandidatoController {
	@Autowired
	private ExameCandidatoService exameCandidatoService;

	@GetMapping
	public Iterable<ExameCandidato> buscar() {
		return exameCandidatoService.buscar();
	}

	@PostMapping
	public ExameCandidato salvar(@RequestBody ExameCandidatoDTO exameCandidatoDTO) {
		System.out.println(exameCandidatoDTO.getNota());
		return exameCandidatoService.salvar(exameCandidatoDTO);
	}

	@DeleteMapping("/exame/{id}")
	public void deletarTodosCandidato(@PathVariable Long id) {
		// candidatos.deleteById(id);
	}

	@DeleteMapping("/candidato/{id}")
	public void deletarTodosExame(@PathVariable Long id) {
		// candidatos.deleteById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable ExameCandidatoId exameCandidatoid) {
		exameCandidatoService.deletar(exameCandidatoid);
	}
}
