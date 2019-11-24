package com.senac.crm_grupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.service.OfertaService;
import com.senac.crm_grupo02.service.ProdutoService;

@Controller
@RequestMapping("funil")
public class FunilController {
	
	@Autowired
	ProdutoService servicoProduto;
	
	@GetMapping("/listarFunilVendas")
	public ModelAndView paginaPrincipal() {
		ModelAndView mv = new ModelAndView("paginas/funil/funilDeVendas");
		mv.addObject("produtoLista", servicoProduto.searchAll());
		return mv;
	}

}
