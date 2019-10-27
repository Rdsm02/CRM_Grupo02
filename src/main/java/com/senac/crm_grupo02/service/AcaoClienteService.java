package com.senac.crm_grupo02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.AcaoCliente;
import com.senac.crm_grupo02.repository.AcaoClienteRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AcaoClienteService {
	
	@Autowired
	AcaoClienteRepository repoAcaoCliente;
	
	public AcaoCliente search(Integer id) throws ObjectNotFoundException{
		Optional<AcaoCliente> acaoCliente = repoAcaoCliente.findById(id);
		return acaoCliente.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + AcaoCliente.class.getName()));		
	}
	

	public AcaoCliente save(AcaoCliente acaoCliente) {
		acaoCliente.setId(null);
		return repoAcaoCliente.save(acaoCliente);
	}
	
	public List<AcaoCliente> searchAll(){
		return repoAcaoCliente.findAll();
	}
	
	
	public List<AcaoCliente> saveAll(List<AcaoCliente> acaoClientes){
		return repoAcaoCliente.saveAll(acaoClientes);
	}
	
	
	public void delete(Integer id) {
		repoAcaoCliente.deleteById(id);
	}
}
