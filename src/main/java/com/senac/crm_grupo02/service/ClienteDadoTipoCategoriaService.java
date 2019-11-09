package com.senac.crm_grupo02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.ClienteDadoTipoCategoria;
import com.senac.crm_grupo02.repository.ClienteDadoTipoCategoriaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteDadoTipoCategoriaService {
	
	@Autowired
	ClienteDadoTipoCategoriaRepository repoClienteDadoTipoCategoria;
	
	public ClienteDadoTipoCategoria search(Integer id) throws ObjectNotFoundException{
		Optional<ClienteDadoTipoCategoria> clienteDadoTipoCategoria = repoClienteDadoTipoCategoria.findById(id);
		return clienteDadoTipoCategoria.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + ClienteDadoTipoCategoria.class.getName()));		
	}
	
	public List<ClienteDadoTipoCategoria> searchAll(){
		return repoClienteDadoTipoCategoria.findAll();
	}
	
	public ClienteDadoTipoCategoria save(ClienteDadoTipoCategoria clienteDadoTipoCategoria) {
		return repoClienteDadoTipoCategoria.save(clienteDadoTipoCategoria);
	}
	
	public List<ClienteDadoTipoCategoria> saveAll(List<ClienteDadoTipoCategoria> clienteDadoTipoCategorias){
		return repoClienteDadoTipoCategoria.saveAll(clienteDadoTipoCategorias);
	}
	
	public ClienteDadoTipoCategoria edit (ClienteDadoTipoCategoria clienteDadoTipoCategoria) throws ObjectNotFoundException{
		ClienteDadoTipoCategoria clienteDadoTipoCategoriaAntigo = search(clienteDadoTipoCategoria.getCodigo());
		clienteDadoTipoCategoriaAntigo.setDescricao(clienteDadoTipoCategoria.getDescricao());
		clienteDadoTipoCategoriaAntigo.setStatus(clienteDadoTipoCategoria.getStatus());		
		return save(clienteDadoTipoCategoriaAntigo);
	}
	
	public void delete(Integer id) {
		repoClienteDadoTipoCategoria.deleteById(id);
	}

}
