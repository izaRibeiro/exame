package com.iza.enem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.iza.enem.model.Exame;
import com.iza.enem.service.ExameService;

@RequestMapping("/exames")
@RestController
public class ExameController {
	
	private ExameService exameService;
	//@Autowired
	//private CandidatoRepository candidatoRepository;
	@Autowired
    public void ExameController(ExameService exameService) {
        this.exameService = exameService;
    }

    @PostMapping
    public ResponseEntity<Exame> salvar(@RequestBody Exame e) {
    	Exame exame = exameService.salvar(e);
        return new ResponseEntity<>(exame, HttpStatus.CREATED);
    }
    
	@GetMapping
	public Iterable<Exame> buscarTodos() {
		return exameService.buscarTodos();
	}
}
