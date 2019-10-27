package com.senac.crm_grupo02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.AcaoClienteOferta;
import com.senac.crm_grupo02.repository.AcaoClienteOfertaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AcaoClienteOfertaService {
	
	@Autowired
	AcaoClienteOfertaRepository repoAcaoClienteOferta;
	
	public AcaoClienteOferta search(Integer id) throws ObjectNotFoundException{
		Optional<AcaoClienteOferta> acaoClienteOferta = repoAcaoClienteOferta.findById(id);
		return acaoClienteOferta.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + AcaoClienteOferta.class.getName()));		
	}
	

	public AcaoClienteOferta save(AcaoClienteOferta acaoClienteOferta) {
		acaoClienteOferta.setId(null);
		return repoAcaoClienteOferta.save(acaoClienteOferta);
	}
	
	public List<AcaoClienteOferta> searchAll(){
		return repoAcaoClienteOferta.findAll();
	}
	
	
	public List<AcaoClienteOferta> saveAll(List<AcaoClienteOferta> acaoClienteOferta){
		return repoAcaoClienteOferta.saveAll(acaoClienteOferta);
	}
	
	
	public void delete(Integer id) {
		repoAcaoClienteOferta.deleteById(id);
	}
}
