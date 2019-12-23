package com.iza.enem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.iza.enem.model.Candidato;
import com.iza.enem.model.Exame;
import com.iza.enem.repository.CandidatoRepository;
import com.iza.enem.repository.ExameRepository;

public class ExameController {
	
	@Autowired
	private ExameRepository exameRepository;
	
	@RequestMapping("/exames")
	public ModelAndView listarCandidatos() {
		ModelAndView mv = new ModelAndView("index.html");
		Iterable<Exame> exames = exameRepository.findAll();
		mv.addObject("exames", exames);
		return mv;
	}
}
