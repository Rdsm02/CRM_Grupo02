package com.senac.crm_grupo02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.ClienteDado;
import com.senac.crm_grupo02.repository.ClienteDadoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteDadoService {

	@Autowired
	ClienteDadoRepository repoClienteDado;
	
	public ClienteDado search(Integer id) throws ObjectNotFoundException{
		Optional<ClienteDado> clienteDado = repoClienteDado.findById(id);
		return clienteDado.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + ClienteDado.class.getName()));		
	}
	
	public List<ClienteDado> searchAll(){
		return repoClienteDado.findAll();
	}
	
	public ClienteDado save(ClienteDado clienteDado) {
		return repoClienteDado.save(clienteDado);
	}
	
	public List<ClienteDado> saveAll(List<ClienteDado> clienteDados){
		return repoClienteDado.saveAll(clienteDados);
	}
	
	public ClienteDado edit (ClienteDado clienteDado) throws ObjectNotFoundException{
		ClienteDado clienteDadoAntigo = search(clienteDado.getCodigo());
		clienteDadoAntigo.setDescricao(clienteDado.getDescricao());
		clienteDadoAntigo.setStatus(clienteDado.getStatus());		
		return save(clienteDadoAntigo);
	}
	
	public void delete(Integer id) {
		repoClienteDado.deleteById(id);
	}
	
}
