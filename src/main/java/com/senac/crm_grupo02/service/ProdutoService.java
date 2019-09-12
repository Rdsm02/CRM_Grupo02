package com.senac.crm_grupo02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.Produto;
import com.senac.crm_grupo02.repository.ProdutoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repoProduto;
	
	public Produto search(Integer id) throws ObjectNotFoundException{
		Optional<Produto> produto = repoProduto.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + Produto.class.getName()));		
	}
	
	public List<Produto> searchAll(){
		return repoProduto.findAll();
	}
	
	public Produto save(Produto produto) {
		return repoProduto.save(produto);
	}
	
	public List<Produto> saveAll(List<Produto> produtos){
		return repoProduto.saveAll(produtos);
	}
	
	public Produto edit (Produto produto) throws ObjectNotFoundException{
		Produto produtoAntigo = search(produto.getId());
		produtoAntigo.setId(produto.getId());
		produtoAntigo.setDescricao(produto.getDescricao());
		produtoAntigo.setStatus(produto.getStatus());
		produtoAntigo.setNivelInstrucao(produto.getNivelInstrucao());
		return save(produtoAntigo);
	}
	
	public void delete(Integer id) {
		repoProduto.deleteById(id);
	}

}
