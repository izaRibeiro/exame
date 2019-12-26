package com.iza.enem.controller;

import org.apache.coyote.Response;
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

import com.iza.enem.dto.CandidatoDTO;
import com.iza.enem.model.Candidato;
import com.iza.enem.service.CandidatoService;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/candidatos")
@RestController
public class CandidatoController {
	@Autowired
	private CandidatoService candidatoService;
	//@Autowired
	//private CandidatoRepository candidatoRepository;
	


    @PostMapping
    public ResponseEntity<Candidato> salvar(@RequestBody CandidatoDTO c) {
    	Candidato candidato = candidatoService.salvar(c);
        return new ResponseEntity<>(candidato, HttpStatus.CREATED);
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
	    
	/*@RequestMapping(value="/cadastrarCandidato", method=RequestMethod.GET)
	public String form() {
		return "candidato/formCandidato";
	}
	
	@RequestMapping(value="/cadastrarCandidato", method=RequestMethod.POST)
	public String form(Candidato candidato) {
		candidatoRepository.save(candidato);
		
		return "redirect:/cadastrarCandidato";
	}
	
	@RequestMapping("/candidatos")
	public ModelAndView listarCandidatos() {
		ModelAndView mv = new ModelAndView("index.html");
		Iterable<Candidato> candidatos = candidatoRepository.findAll();
		mv.addObject("candidatos", candidatos);
		return mv;
	}*/
}
