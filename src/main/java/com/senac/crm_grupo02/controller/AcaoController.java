package com.senac.crm_grupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.domain.Acao;
import com.senac.crm_grupo02.service.AcaoService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("acao")
public class AcaoController {

	@Autowired
	private AcaoService servicoAcao;
	
	@GetMapping("/paginaDeAcoes")
	public ModelAndView paginaDeAcoes() {
		ModelAndView mv = new ModelAndView("paginas/acao/paginaAcao");
		mv.addObject("acoes", servicoAcao.searchAll());
		return mv;
	}

	@GetMapping("/listagemAcoes")
	public ModelAndView listagemAcao() {
		ModelAndView mv = new ModelAndView("paginas/acao/listagemAcoes");
		mv.addObject("acoes", servicoAcao.searchAll());
		return mv;
	}	
	
	@GetMapping("/detalheAcoes")
	public ModelAndView detalheAcao() {
		ModelAndView mv = new ModelAndView("paginas/acao/detalheAcoes");
		return mv;
	}
	
	@GetMapping("/listarTodasAcoes")
	public ModelAndView listarTodasAcoes() {
		ModelAndView mv = new ModelAndView("acao/paginaDeAcao");
		mv.addObject("acoes", servicoAcao.searchAll());
		return mv;
	}
	
	@GetMapping("/cadastrarAcao")
	public ModelAndView cadastrarAcao() {
		ModelAndView mv = new ModelAndView("acao/cadastroDeAcao");
		mv.addObject("acao", new Acao());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarAcao(Acao acao) {
		servicoAcao.save(acao);
		return listarTodasAcoes();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarAcao(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("acao/alterarAcao");
		mv.addObject("acao", servicoAcao.search(id));
		return mv;
	}	
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Acao acaoQueFoiAlterado) throws ObjectNotFoundException{
		servicoAcao.save(acaoQueFoiAlterado);
		return listarTodasAcoes();
	}
	
	@GetMapping("excluir/{id}")
	public ModelAndView excluirAcao(@PathVariable("id") Integer idAcaoASerEditado) {
		servicoAcao.delete(idAcaoASerEditado);
		return listarTodasAcoes();
	}	
		
}