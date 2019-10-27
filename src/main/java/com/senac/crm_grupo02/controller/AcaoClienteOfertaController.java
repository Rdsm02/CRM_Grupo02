package com.senac.crm_grupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.domain.AcaoClienteOferta;
import com.senac.crm_grupo02.service.AcaoClienteOfertaService;
import com.senac.crm_grupo02.service.AcaoService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("acaoClienteOferta")
public class AcaoClienteOfertaController {

	
	@Autowired
	AcaoService servicoAcao;
	
	@Autowired
	AcaoClienteOfertaService servicoAcaoClienteOferta;
	
	@GetMapping("/listarTodasAcoesCliente")
	public ModelAndView listarTodasAcoesClientes() {
		ModelAndView mv = new ModelAndView("AcaoClienteOferta/paginaDeAcaoClienteOferta");
		mv.addObject("AcaoClienteOfertas", servicoAcaoClienteOferta.searchAll());
		return mv;
	}	
	
	@GetMapping("/cadastrarAcoesClienteOferta")
	public ModelAndView cadastrarOfertas() {
		ModelAndView mv = new ModelAndView("AcaoCliente/cadastroDeAcaoClienteOferta");
		mv.addObject("acaoClienteOferta", new AcaoClienteOferta());
		mv.addObject("acoes", servicoAcao.searchAll());
		return mv;
	}	
	
	@PostMapping("/salvar")
	public String salvarAcaoClienteOferta(AcaoClienteOferta acaoClienteOferta) {
		servicoAcaoClienteOferta.save(acaoClienteOferta);
		return "redirect:/AcaoClienteOferta/paginaDeAcaoClienteOferta";

	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarAcaoCliente(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("acaoClienteOferta/alterarAcaoClienteOferta");
		mv.addObject("acaoCliente", servicoAcaoClienteOferta.search(id));
		mv.addObject("acoes", servicoAcao.searchAll());
		mv.addObject("clientes", servicoAcaoClienteOferta.searchAll());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(AcaoClienteOferta acaoClienteQueFoiAlterado) throws ObjectNotFoundException{
		servicoAcaoClienteOferta.save(acaoClienteQueFoiAlterado);
		return listarTodasAcoesClientes();
	}
	
	@GetMapping("excluir/{id}")
	public ModelAndView excluirOferta(@PathVariable("id") Integer idDoAcaoClienteASerEditado) {
		servicoAcaoClienteOferta.delete(idDoAcaoClienteASerEditado);
		return listarTodasAcoesClientes();
	}
	
}