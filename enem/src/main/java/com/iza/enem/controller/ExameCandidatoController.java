package com.iza.enem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.iza.enem.dto.ExameCandidatoDTO;
import com.iza.enem.model.ExameCandidato;
import com.iza.enem.model.ExameCandidatoId;
import com.iza.enem.service.ExameCandidatoService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/exameCandidato")
@RestController
public class ExameCandidatoController {
	@Autowired
	private ExameCandidatoService exameCandidatoService;

	@GetMapping
	public Iterable<ExameCandidatoDTO> buscar() {
		return exameCandidatoService.buscarTodos();
	}

	@GetMapping("/{idExame}/{idCandidato}")
	public ExameCandidatoDTO buscar(@PathVariable Integer idCandidato,@PathVariable Integer idExame) {
		return exameCandidatoService.buscar(new ExameCandidatoId(idExame, idCandidato));
	}
	
	@PostMapping
	public ExameCandidato salvar(@RequestBody ExameCandidatoDTO exameCandidatoDTO) {
		
		try {
			return exameCandidatoService.salvar(exameCandidatoDTO);
		}catch(RuntimeException e) {
			throw new  ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
		
	}

	@PutMapping("/{idExame}/{idCandidato}")
	public ExameCandidato editar(@RequestBody ExameCandidatoDTO exameCandidatoDTO) {
		System.out.println(exameCandidatoDTO.getNota());
		return exameCandidatoService.salvar(exameCandidatoDTO);
	}
	
	@DeleteMapping("/{idExame}/{idCandidato}")
	public void deletar(@PathVariable Integer idExame, @PathVariable Integer idCandidato) {
		exameCandidatoService.deletar(new ExameCandidatoId(idExame, idCandidato));
	}
}
