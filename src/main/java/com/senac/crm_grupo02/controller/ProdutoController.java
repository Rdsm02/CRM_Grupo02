package com.senac.crm_grupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.domain.NivelInstrucao;
import com.senac.crm_grupo02.domain.Produto;
import com.senac.crm_grupo02.service.NivelInstrucaoService;
import com.senac.crm_grupo02.service.ProdutoService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("produto")
public class ProdutoController {
	
	@Autowired
	ProdutoService servicoProduto;
	
	@Autowired
	NivelInstrucaoService servicoNivelInstrucao;
	
	@GetMapping("/listagemProdutos")
	public ModelAndView listagemProduto() {
		ModelAndView mv = new ModelAndView("paginas/produto/listagemProdutos");
		//mv.addObject("clientes", servicoCliente.searchAll());
		return mv;
	}
	
	@GetMapping("/detalheProdutos")
	public ModelAndView detalheProduto() {
		ModelAndView mv = new ModelAndView("paginas/produto/detalheProdutos");
		//mv.addObject("clientes", servicoCliente.searchAll());
		return mv;
	}

	@GetMapping("/listarTodosProdutos")
	public ModelAndView listarTodosOsProdutos() {
		ModelAndView mv = new ModelAndView("produto/paginaDeProdutos");
		mv.addObject("produtos", servicoProduto.searchAll());
		mv.addObject("nivelInstrucoes", servicoNivelInstrucao.searchAll());
		return mv;
	}

	@GetMapping("/cadastrarProdutos")
	public ModelAndView cadastrarProdutos() {
		ModelAndView mv = new ModelAndView("produto/cadastroDeProdutos");
		mv.addObject("produto", new Produto());
		mv.addObject("nivelInstrucoes", servicoNivelInstrucao.searchAll());
		return mv;
	}

	@PostMapping("/salvar")
	public String salvarProdutos(Produto produto) {
		servicoProduto.save(produto);
		return "redirect:/produto/listarTodosProdutos";
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarProduto(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("produto/alterarProduto");
		mv.addObject("produto", servicoProduto.search(id));
		mv.addObject("nivelInstrucoes", servicoNivelInstrucao.searchAll());
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Produto produtoQueFoiAlterado) throws ObjectNotFoundException{
		servicoProduto.save(produtoQueFoiAlterado);
		return listarTodosOsProdutos();
	}
	
	@GetMapping("excluir/{id}")
	public ModelAndView excluirProduto(@PathVariable("id") Integer idDoProdutoASerEditado) {
		servicoProduto.delete(idDoProdutoASerEditado);
		return listarTodosOsProdutos();
	}

}
