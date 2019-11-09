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
	
	@GetMapping("/listagemProduto")
	public ModelAndView listagemProduto() {
		ModelAndView mv = new ModelAndView("paginas/produto/listagemProduto");
		mv.addObject("produtos", servicoProduto.searchAll());
		return mv;
	}
	
	@GetMapping("/detalheProduto")
	public ModelAndView detalheProduto() {
		ModelAndView mv = new ModelAndView("paginas/produto/detalheProduto");
		//mv.addObject("clientes", servicoCliente.searchAll());
		return mv;
	}

	@GetMapping("/listarTodosProduto")
	public ModelAndView listarTodosOsProdutos() {
		ModelAndView mv = new ModelAndView("paginas/produto/paginaDeProduto");
		mv.addObject("produtos", servicoProduto.searchAll());
		mv.addObject("nivelInstrucoes", servicoNivelInstrucao.searchAll());
		return mv;
	}

	@GetMapping("/cadastrarProduto")
	public ModelAndView cadastrarProdutos() {
		ModelAndView mv = new ModelAndView("paginas/produto/cadastroProduto");
		mv.addObject("produtoLista", servicoProduto.searchAll());
		mv.addObject("nivelInstrucoes", servicoNivelInstrucao.searchAll());
		return mv;
	}

	@PostMapping("/salvar")
	public String salvarProdutos(Produto produto) {
		servicoProduto.save(produto);
		return "redirect:/produto/listarTodosProduto";
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarProduto(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("pagina/produto/alterarProduto");
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
