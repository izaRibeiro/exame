package com.iza.enem.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iza.enem.dto.CandidatoDTO;
import com.iza.enem.model.Candidato;
import com.iza.enem.service.CandidatoService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/candidatos")
@RestController
public class CandidatoController {

	@Autowired
	private CandidatoService candidatoService;

	
	@PostMapping
	public ResponseEntity<CandidatoDTO> salvar(@RequestBody CandidatoDTO candidatoDTO) {
		Candidato candidato = candidatoService.salvar(candidatoDTO);

		return new ResponseEntity<>(candidato.converterParaDTO(), HttpStatus.CREATED);
	}

	@GetMapping
	public Iterable<Candidato> buscarTodos() {
		return candidatoService.buscarTodos();
	}

	@GetMapping("/{id}")
	public Candidato buscar(@PathVariable Integer id) {
		return candidatoService.buscar(id);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Integer id) {
		candidatoService.excluir(id);
	}
	
	@PutMapping
	public ResponseEntity<CandidatoDTO> editar(@RequestBody CandidatoDTO candidatoDTO) {
		Candidato candidato = candidatoService.salvar(candidatoDTO);
		return new ResponseEntity<>(candidato.converterParaDTO(), HttpStatus.CREATED);
	}

	/*@PostMapping("/{ide}/{idc}")
	public void inserirNota(@RequestBody Integer ide, Integer idc) {

		jdbcTemplate.update(
			    "INSERT INTO exame_candidato (ID_CANDIDATO, ID_EXAME) VALUES (?, ?)",
			    ide, idc
			);
		
	}*/
}
