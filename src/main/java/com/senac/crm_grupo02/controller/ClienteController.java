package com.senac.crm_grupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.domain.Cliente;
import com.senac.crm_grupo02.service.AcaoClienteService;
import com.senac.crm_grupo02.service.AcaoService;
import com.senac.crm_grupo02.service.ClienteService;

import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService servicoCliente;
	
	@Autowired
	private AcaoService servicoAcao;
	
	@Autowired
	private AcaoClienteService servicoAcaoCliente;
	
	@GetMapping("/listagemClientes")
	public ModelAndView listagemCliente() {
		ModelAndView mv = new ModelAndView("paginas/cliente/listagemClientes");
		mv.addObject("clientes", servicoCliente.searchAll());
		return mv;
	}
	
	@GetMapping("/detalheClientes/{id}")
	public ModelAndView detalheCliente(@PathVariable("id") Integer idCliente) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("paginas/cliente/detalheClientes");
		mv.addObject("atividadeLista", servicoAcao.searchAll());
		mv.addObject("listaAcaoCliente", servicoAcaoCliente.listarHistoricoCliente(idCliente));
		return mv;
	}

	@GetMapping("/listarTodosClientes")
	public ModelAndView listarTodosOsClientes() {
		ModelAndView mv = new ModelAndView("cliente/paginaDeClientes");
		mv.addObject("clientes", servicoCliente.searchAll());
		return mv;
	}

	@GetMapping("/cadastrarClientes")
	public ModelAndView cadastrarClientes() {
		ModelAndView mv = new ModelAndView("cliente/cadastroDeClientes");
		mv.addObject("cliente", new Cliente());
		return mv;
	}

	@PostMapping("/salvar")
	public ModelAndView salvarClientes(Cliente cliente) {
		servicoCliente.save(cliente);
		return listarTodosOsClientes();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarCliente(@PathVariable("id") Integer id) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("cliente/alterarCliente");
		mv.addObject("cliente", servicoCliente.search(id));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Cliente clienteQueFoiAlterado) throws ObjectNotFoundException{
		servicoCliente.save(clienteQueFoiAlterado);
		return listarTodosOsClientes();
	}
	
	@GetMapping("excluir/{id}")
	public ModelAndView excluirCliente(@PathVariable("id") Integer idDoClienteASerEditado) {
		servicoCliente.delete(idDoClienteASerEditado);
		return listarTodosOsClientes();
	}

}
