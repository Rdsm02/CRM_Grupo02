package com.senac.crm_grupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.domain.Oferta;
import com.senac.crm_grupo02.service.OfertaService;
import com.senac.crm_grupo02.service.ProdutoService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("oferta")
public class OfertaController {
	
	@Autowired
	OfertaService servicoOferta;
	
	@Autowired
	ProdutoService servicoProdruto;

	@GetMapping("/listarTodosOfertas")
	public ModelAndView listarTodosOsOfertas() {
		ModelAndView mv = new ModelAndView("oferta/paginaDeOferta");
		mv.addObject("ofertas", servicoOferta.searchAll());
		return mv;
	}

	@GetMapping("/cadastrarOfertas")
	public ModelAndView cadastrarOfertas() {
		ModelAndView mv = new ModelAndView("oferta/cadastroDeOfertas");
		mv.addObject("oferta", new Oferta());
		mv.addObject("produtos", servicoProdruto.searchAll());
		return mv;
	}

	@PostMapping("/salvar")
	public String salvarOfertas(Oferta oferta) {
		servicoOferta.save(oferta);
		return "redirect:/oferta/listarTodosOfertas";
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarOferta(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("oferta/alterarOferta");
		mv.addObject("oferta", servicoOferta.search(id));
		mv.addObject("produtos", servicoProdruto.searchAll());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Oferta ofertaQueFoiAlterado) throws ObjectNotFoundException{
		servicoOferta.save(ofertaQueFoiAlterado);
		return listarTodosOsOfertas();
	}
	
	@GetMapping("excluir/{id}")
	public ModelAndView excluirOferta(@PathVariable("id") Integer idDoOfertaASerEditado) {
		servicoOferta.delete(idDoOfertaASerEditado);
		return listarTodosOsOfertas();
	}

}
