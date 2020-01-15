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
import org.springframework.web.server.ResponseStatusException;

import com.iza.enem.dto.CandidatoDTO;
import com.iza.enem.dto.ExameDTO;
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
		try {
			Candidato candidato = candidatoService.salvar(candidatoDTO);

			return new ResponseEntity<>(candidato.converterParaDTO(), HttpStatus.CREATED);
		}catch(RuntimeException e) {
			throw new  ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
		}
	}

	@GetMapping
	public Iterable<CandidatoDTO> buscarTodos() {
		return candidatoService.buscarTodos();
	}

	@GetMapping("/{id}")
	public Candidato buscar(@PathVariable Integer id) {
		return candidatoService.buscar(id);
	}
	
	@GetMapping("/email/{email}")
	public Candidato buscarPorEmail(@PathVariable String email) {
		return candidatoService.buscarPorEmail(email);
	}
	
	@GetMapping("/senha/{senha}")
	public Iterable<Candidato> buscarPorSenha(@PathVariable String senha) {
		return candidatoService.buscarPorSenha(senha);
	}

	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Integer id) {
		candidatoService.excluir(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> editar(@PathVariable Integer id, @RequestBody CandidatoDTO c) {
		try {
			
			return new ResponseEntity<>(candidatoService.editar(c) , HttpStatus.CREATED);
		}catch(RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
	


}
