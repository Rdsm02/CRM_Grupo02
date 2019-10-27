package com.senac.crm_grupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.domain.AcaoCliente;
import com.senac.crm_grupo02.service.AcaoClienteService;
import com.senac.crm_grupo02.service.AcaoService;
import com.senac.crm_grupo02.service.ClienteService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("acaoCliente")
public class AcaoClienteController {

	
	@Autowired
	AcaoService servicoAcao;
	
	@Autowired
	ClienteService servicoCliente;
	
	@Autowired
	AcaoClienteService servicoAcaoCliente;
	
	@GetMapping("/listarTodasAcoesCliente")
	public ModelAndView listarTodasAcoesClientes() {
		ModelAndView mv = new ModelAndView("AcaoCliente/paginaDeAcaoCliente");
		mv.addObject("AcaoClientes", servicoAcaoCliente.searchAll());
		return mv;
	}	
	
	@GetMapping("/cadastrarAcoesCliente")
	public ModelAndView cadastrarOfertas() {
		ModelAndView mv = new ModelAndView("AcaoCliente/cadastroDeAcaoCliente");
		mv.addObject("acaoCliente", new AcaoCliente());
		mv.addObject("acoes", servicoAcao.searchAll());
		mv.addObject("clientes", servicoCliente.searchAll());
		return mv;
	}	
	
	@PostMapping("/salvar")
	public String salvarAcaoCliente(AcaoCliente acaoCliente) {
		servicoAcaoCliente.save(acaoCliente);
		return "redirect:/acaoCliente/listarTodasAcoesCliente";

	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarAcaoCliente(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("acaoCliente/alterarAcaoCliente");
		mv.addObject("acaoCliente", servicoAcaoCliente.search(id));
		mv.addObject("acoes", servicoAcao.searchAll());
		mv.addObject("clientes", servicoCliente.searchAll());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(AcaoCliente acaoClienteQueFoiAlterado) throws ObjectNotFoundException{
		servicoAcaoCliente.save(acaoClienteQueFoiAlterado);
		return listarTodasAcoesClientes();
	}
	
	@GetMapping("excluir/{id}")
	public ModelAndView excluirOferta(@PathVariable("id") Integer idDoAcaoClienteASerEditado) {
		servicoAcaoCliente.delete(idDoAcaoClienteASerEditado);
		return listarTodasAcoesClientes();
	}
	
}