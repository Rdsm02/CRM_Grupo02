package com.senac.crm_grupo02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.Cliente;
import com.senac.crm_grupo02.repository.ClienteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository repoCliente;
	
	public Cliente search(Integer id) throws ObjectNotFoundException{
		Optional<Cliente> cliente = repoCliente.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + Cliente.class.getName()));		
	}
	
	public List<Cliente> searchAll(){
		return repoCliente.findAll();
	}
	
	public Cliente save(Cliente cliente) {
		return repoCliente.save(cliente);
	}
	
	public List<Cliente> saveAll(List<Cliente> clientes){
		return repoCliente.saveAll(clientes);
	}
	
	public Cliente edit (Cliente cliente) throws ObjectNotFoundException{
		Cliente clienteAntigo = search(cliente.getId());
		clienteAntigo.setId(cliente.getId());
		clienteAntigo.setCpf(cliente.getCpf());
		clienteAntigo.setNome(cliente.getNome());
		clienteAntigo.setSobrenome(cliente.getSobrenome());
		clienteAntigo.setEmail(cliente.getEmail());
		clienteAntigo.setStatus(cliente.getStatus());		
		return save(clienteAntigo);
	}
	
	public void delete(Integer id) {
		repoCliente.deleteById(id);
	}

}
