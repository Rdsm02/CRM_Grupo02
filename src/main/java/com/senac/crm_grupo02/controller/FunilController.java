package com.senac.crm_grupo02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("funil")
public class FunilController {
	
	@GetMapping("/listarFunilVendas")
	public ModelAndView paginaPrincipal() {
		ModelAndView mv = new ModelAndView("paginas/funil/funilDeVendas");
		//mv.addObject("clientes", servicoCliente.searchAll());
		return mv;
	}

}
