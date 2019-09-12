package com.senac.crm_grupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.domain.NivelInstrucao;
import com.senac.crm_grupo02.service.NivelInstrucaoService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("nivelInstrucao")
public class NivelInstrucaoController {
	
	@Autowired
	private NivelInstrucaoService servicoNivelInstrucao;

	@GetMapping("/listarTodosNivelInstrucaos")
	public ModelAndView listarTodosOsNivelInstrucaos() {
		ModelAndView mv = new ModelAndView("nivelInstrucao/paginaDeNivelInstrucaos");
		mv.addObject("nivelInstrucaos", servicoNivelInstrucao.searchAll());
		return mv;
	}

	@GetMapping("/cadastrarNivelInstrucaos")
	public ModelAndView cadastrarNivelInstrucaos() {
		ModelAndView mv = new ModelAndView("nivelInstrucao/cadastroDeNivelInstrucaos");
		mv.addObject("nivelInstrucao", new NivelInstrucao());
		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvarNivelInstrucaos(NivelInstrucao nivelInstrucao) {
		servicoNivelInstrucao.save(nivelInstrucao);
		return listarTodosOsNivelInstrucaos();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarNivelInstrucao(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("nivelInstrucao/alterarNivelInstrucao");
		mv.addObject("nivelInstrucao", servicoNivelInstrucao.search(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(NivelInstrucao nivelInstrucaoQueFoiAlterado) throws ObjectNotFoundException{
		servicoNivelInstrucao.save(nivelInstrucaoQueFoiAlterado);
		return listarTodosOsNivelInstrucaos();
	}
	
	@GetMapping("excluir/{id}")
	public ModelAndView excluirNivelInstrucao(@PathVariable("id") Integer idDoNivelInstrucaoASerEditado) {
		servicoNivelInstrucao.delete(idDoNivelInstrucaoASerEditado);
		return listarTodosOsNivelInstrucaos();
	}

}
