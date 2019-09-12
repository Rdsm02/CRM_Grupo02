package com.senac.crm_grupo02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.ClientePossivelProduto;
import com.senac.crm_grupo02.domain.Produto;
import com.senac.crm_grupo02.repository.ClientePossivelProdutoRepository;
import com.senac.crm_grupo02.repository.ProdutoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClientePossivelProdutoService {
	
	@Autowired
	ClientePossivelProdutoRepository repoClientePossivelProduto;
	
	public ClientePossivelProduto search(Integer id) throws ObjectNotFoundException{
		Optional<ClientePossivelProduto> clientePossivelProduto = repoClientePossivelProduto.findById(id);
		return clientePossivelProduto.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + ClientePossivelProduto.class.getName()));		
	}
	
	public List<ClientePossivelProduto> searchAll(){
		return repoClientePossivelProduto.findAll();
	}
	
	public ClientePossivelProduto save(ClientePossivelProduto clientePossivelProduto) {
		return repoClientePossivelProduto.save(clientePossivelProduto);
	}
	
	public List<ClientePossivelProduto> saveAll(List<ClientePossivelProduto> clientePossivelProdutos){
		return repoClientePossivelProduto.saveAll(clientePossivelProdutos);
	}
	
	/*public ClientePossivelProduto edit (ClientePossivelProduto clientePossivelProduto) throws ObjectNotFoundException{
		ClientePossivelProduto clientePossivelProdutoAntigo = search(clientePossivelProduto.getClienteId());
		clientePossivelProdutoAntigo.setProdutoId(clientePossivelProduto.getProdutoId());
		return save(clientePossivelProdutoAntigo);
	}*/
	
	public void delete(Integer id) {
		repoClientePossivelProduto.deleteById(id);
	}

}
