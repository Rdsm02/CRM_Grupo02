package com.senac.crm_grupo02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.ClienteDadoTipo;
import com.senac.crm_grupo02.repository.ClienteDadoTipoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteDadoTipoService {
	
	@Autowired
	ClienteDadoTipoRepository repoClienteDadoTipo;
	
	public ClienteDadoTipo search(Integer id) throws ObjectNotFoundException{
		Optional<ClienteDadoTipo> clienteDadoTipo = repoClienteDadoTipo.findById(id);
		return clienteDadoTipo.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + ClienteDadoTipo.class.getName()));		
	}
	
	public List<ClienteDadoTipo> searchAll(){
		return repoClienteDadoTipo.findAll();
	}
	
	public ClienteDadoTipo save(ClienteDadoTipo clienteDadoTipo) {
		return repoClienteDadoTipo.save(clienteDadoTipo);
	}
	
	public List<ClienteDadoTipo> saveAll(List<ClienteDadoTipo> clienteDadoTipos){
		return repoClienteDadoTipo.saveAll(clienteDadoTipos);
	}
	
	public ClienteDadoTipo edit (ClienteDadoTipo clienteDadoTipo) throws ObjectNotFoundException{
		ClienteDadoTipo clienteDadoTipoAntigo = search(clienteDadoTipo.getCodigo());
		clienteDadoTipoAntigo.setDescricao(clienteDadoTipo.getDescricao());
		clienteDadoTipoAntigo.setStatus(clienteDadoTipo.getStatus());	
		clienteDadoTipoAntigo.setObrigatorio(clienteDadoTipo.getObrigatorio());
		clienteDadoTipoAntigo.setPadrao(clienteDadoTipo.getPadrao());
		clienteDadoTipoAntigo.setMascara(clienteDadoTipo.getMascara());
		
		return save(clienteDadoTipoAntigo);
	}
	
	public void delete(Integer id) {
		repoClienteDadoTipo.deleteById(id);
	}
	

}
