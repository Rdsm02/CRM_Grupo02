package com.senac.crm_grupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.service.OfertaService;

@Controller
@RequestMapping("funil")
public class FunilController {
	
	@Autowired
	OfertaService servicoOferta;	
	
	@GetMapping("/listarFunilVendas")
	public ModelAndView paginaPrincipal() {
		ModelAndView mv = new ModelAndView("paginas/funil/funilDeVendas");
		mv.addObject("ofertaLista", servicoOferta.searchAll());
		return mv;
	}

}
