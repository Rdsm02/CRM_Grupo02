package com.senac.crm_grupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.domain.Produto;
import com.senac.crm_grupo02.service.EtapaFunilService;

@Controller
@RequestMapping("etapa")
public class EtapaFunilController {
	
	@Autowired
	EtapaFunilService servicoEtapaFunil;

	@GetMapping("/listagemEtapas")
	public ModelAndView listagemEtapa() {
		ModelAndView mv = new ModelAndView("paginas/etapa/listagemProdutos");
		mv.addObject("etapas", servicoEtapaFunil.searchAll());
		return mv;
	}	
	
	@GetMapping("/detalheEtapas")
	public ModelAndView detalheEtapa() {
		ModelAndView mv = new ModelAndView("paginas/etapa/detalheEtapas");
		return mv;
	}

	@GetMapping("/listarTodosEtapas")
	public ModelAndView listarTodosOsProdutos() {
		ModelAndView mv = new ModelAndView("produto/paginaDeEtapas");
		mv.addObject("etapas", servicoEtapaFunil.searchAll());
		return mv;
	}

	@GetMapping("/cadastrarEtapas")
	public ModelAndView cadastrarEtapas() {
		ModelAndView mv = new ModelAndView("etapa/cadastroDeProdutos");
		mv.addObject("etapa", new Produto());
		return mv;
	}	
	
}