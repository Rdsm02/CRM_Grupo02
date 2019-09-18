package com.senac.crm_grupo02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.ClienteOferta;
import com.senac.crm_grupo02.domain.ClienteOfertaId;
import com.senac.crm_grupo02.repository.ClienteOfertaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteOfertaService {

	@Autowired
	ClienteOfertaRepository repoClienteOferta;

	public ClienteOferta search(ClienteOfertaId id) throws ObjectNotFoundException {
		Optional<ClienteOferta> clienteOferta = repoClienteOferta.findById(id);
		
		  return clienteOferta.orElseThrow(() -> new ObjectNotFoundException(
		  "não encontrado. id: " + id + ", Tipo!" + ClienteOferta.class.getName()));
		 
	}

	public List<ClienteOferta> searchAll() {
		return repoClienteOferta.findAll();
	}

	public ClienteOferta save(ClienteOferta clienteOferta) {
		return repoClienteOferta.save(clienteOferta);
	}

	public List<ClienteOferta> saveAll(List<ClienteOferta> clienteOfertas) {
		return repoClienteOferta.saveAll(clienteOfertas);
	}

	/*
	 * public ClienteOferta edit (ClienteOferta clienteOferta) throws
	 * ObjectNotFoundException{ ClienteOferta clienteOfertaAntigo =
	 * search(clienteOferta.getClienteId().getId());
	 * clienteOfertaAntigo.setProdutoId(clienteOferta.getProdutoId());
	 * clienteOfertaAntigo.setClienteId(clienteOferta.getClienteId());
	 * clienteOfertaAntigo.setClienteOfertaStatus(clienteOferta.
	 * getClienteOfertaStatus());
	 * clienteOfertaAntigo.setClienteOfertaData(clienteOferta.getClienteOfertaData()
	 * ); return save(clienteOfertaAntigo); }
	 */

	public void delete(ClienteOfertaId id) {
		repoClienteOferta.deleteById(id);
	}

}