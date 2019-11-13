package com.senac.crm_grupo02.controllerREST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
	
	@RequestMapping(value = "/produtoNivelInstrucao", method = RequestMethod.GET)
	public ResponseEntity<List<NivelInstrucao>> ObterDadoTipoClienteCategoria() throws ObjectNotFoundException {
		List<NivelInstrucao> produtoNivelInstrucao = new ArrayList<NivelInstrucao>();
		produtoNivelInstrucao = servicoNivelInstrucao.searchAll();		
		Map<Integer, NivelInstrucao> produtoNivelInstrucaohas = new HashMap<Integer, NivelInstrucao>();
		int cont = 1;
		
		for (NivelInstrucao produtoNivelInstrucaoItem : produtoNivelInstrucao) {							
			produtoNivelInstrucaohas.put(cont, produtoNivelInstrucaoItem);	
			cont++;							
		}
		
		return new ResponseEntity<List<NivelInstrucao>>(new ArrayList<NivelInstrucao>(produtoNivelInstrucaohas.values()), HttpStatus.OK);		
	}
	
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
    public Produto editarAcao(@RequestBody Produto produto) throws ObjectNotFoundException{
		
		Produto produtoNovo = new Produto();
		produtoNovo.setId(produto.getId());
		produtoNovo.setDescricao(produto.getDescricao());
		produtoNovo.setStatus(produto.getStatus());		
		produtoNovo.setNivelInstrucao(servicoNivelInstrucao.search(produto.getNivelInstrucao().getId()));
		
		
		servicoProduto.edit(produtoNovo);
		
        return produtoNovo;
    }
	
	@RequestMapping(value = "/obterProduto", method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> obterProduto() throws ObjectNotFoundException {
		
		List<Produto> listaProduto = new ArrayList<Produto>();
		listaProduto = servicoProduto.searchAll();		
		Map<Integer, Produto> listaProdutohas = new HashMap<Integer, Produto>();
		int cont = 1;
		
		for (Produto itemProduto : listaProduto) {							
			listaProdutohas.put(cont, itemProduto);	
			cont++;							
		}
		return new ResponseEntity<List<Produto>>(new ArrayList<Produto>(listaProdutohas.values()), HttpStatus.OK);		
	}

}
