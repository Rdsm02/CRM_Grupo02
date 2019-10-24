package com.senac.crm_grupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.service.ClienteDadoTipoService;

@Controller
@RequestMapping("clienteDadotipo")
public class ClienteDadoTipoController {
	
	@Autowired
	ClienteDadoTipoService servicoClienteDadoTipo;
	
	@GetMapping("/listarDadoTipo")
	public ModelAndView paginaPrincipal() {
		ModelAndView mv = new ModelAndView("paginas/parametrizacao/categoriaDadoCliente");
		mv.addObject("tipoDados", servicoClienteDadoTipo.searchAll());
		return mv;
	}

}
