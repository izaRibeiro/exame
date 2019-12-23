package com.iza.enem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iza.enem.model.Candidato;
import com.iza.enem.repository.CandidatoRepository;

@Controller
public class CandidatoController {
	
	@Autowired
	private CandidatoRepository candidatoRepository;
	
	@RequestMapping(value="/cadastrarCandidato", method=RequestMethod.GET)
	public String form() {
		return "candidato/formCandidato";
	}
	
	@RequestMapping(value="/cadastrarCandidato", method=RequestMethod.POST)
	public String form(Candidato candidato) {
		candidatoRepository.save(candidato);
		
		return "redirect:/cadastrarCandidato";
	}
}
