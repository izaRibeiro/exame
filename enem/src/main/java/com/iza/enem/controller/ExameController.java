package com.iza.enem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.iza.enem.dto.ExameDTO;
import com.iza.enem.model.Exame;
import com.iza.enem.service.ExameService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/exames")
@RestController
public class ExameController {
	
	@Autowired
	private ExameService exameService;
    
    @PostMapping
    public ResponseEntity<Exame> salvar(@RequestBody ExameDTO examedto) {
    	try {
        	Exame exame = exameService.salvar(examedto);
            return new ResponseEntity<>(exame, HttpStatus.CREATED);
    	}catch(RuntimeException e) {
    		throw new  ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage(), e);
    	}

    }
    
	@GetMapping
	public Iterable<ExameDTO> buscarTodos() {
		return exameService.buscarTodos();
	}
	
	@GetMapping("/{id}")
	public ExameDTO buscar(@PathVariable Integer id) {
		Exame exame = exameService.buscar(id);
		return exame.converterParaDTO();
	}
	
	@DeleteMapping("/{id}")
	public void excluir(@PathVariable Integer id) {
		exameService.excluir(id);
	}
	
    @PutMapping("/{id}")
    public ResponseEntity<Exame> editar(@PathVariable Integer id, @RequestBody ExameDTO e) {
    	Exame exame = exameService.editar(e);
        return new ResponseEntity<>(exame, HttpStatus.CREATED);
    }
    
}
