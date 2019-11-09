package com.senac.crm_grupo02.controllerREST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.senac.crm_grupo02.domain.ClienteDadoTipo;
import com.senac.crm_grupo02.domain.NivelInstrucao;
import com.senac.crm_grupo02.domain.Produto;
import com.senac.crm_grupo02.service.NivelInstrucaoService;
import com.senac.crm_grupo02.service.ProdutoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/produtoREST")
public class ProdutoControllerREST {
	
	@Autowired
	NivelInstrucaoService servicoNivelInstrucao;
	
	@Autowired
	ProdutoService servicoProduto;
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/cadastrarProduto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Produto cadastrarCliente(@RequestBody Produto produto) throws ObjectNotFoundException{
		
		Produto produtoNovo = new Produto();
		produtoNovo.setId(produto.getId());
		produtoNovo.setDescricao(produto.getDescricao());
		produtoNovo.setStatus(produto.getStatus());
		produtoNovo.setNivelInstrucao(servicoNivelInstrucao.search(produto.getNivelInstrucao().getId()));
	
		servicoProduto.save(produtoNovo);
		
        return produtoNovo;
    }	
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/editarProduto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Produto editarProduto(@RequestBody Produto produto) throws ObjectNotFoundException{
		
		servicoProduto.edit(produto);
		
        return produto;
    }	
		
	
	@RequestMapping(value = "/produtoNivelInstrucao", method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> ObterDadoTipoClienteCategoria() throws ObjectNotFoundException {
		
		List<Produto> listaProduto = new ArrayList<Produto>();
		listaProduto = servicoProduto.searchAll();		
		Map<Integer, Produto> produtohas = new HashMap<Integer, Produto>();
		int cont = 1;
		
		for (Produto itemProduto : listaProduto) {							
			produtohas.put(cont, itemProduto);	
			cont++;							
		}
		
		return new ResponseEntity<List<Produto>>(new ArrayList<Produto>(produtohas.values()), HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/obterProdutoPorId", method = RequestMethod.GET)
	public ResponseEntity<Produto> obterProduto(@RequestParam("produto") int produto) throws ObjectNotFoundException {
		
		Produto pR = servicoProduto.search(produto);		
		
		return new ResponseEntity<Produto>(pR, HttpStatus.OK);		
	}


}
