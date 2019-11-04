package com.senac.crm_grupo02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.EtapaFunil;
import com.senac.crm_grupo02.domain.NivelInstrucao;
import com.senac.crm_grupo02.repository.EtapaFunilRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EtapaFunilService {

	@Autowired
	EtapaFunilRepository repoEtapaFunil;
	
	public EtapaFunil search(Integer id) throws ObjectNotFoundException{
		Optional<EtapaFunil> etapaFunil = repoEtapaFunil.findById(id);
		return etapaFunil.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + EtapaFunil.class.getName()));		
	}
	
	public List<EtapaFunil> searchAll(){
		return repoEtapaFunil.findAll();
	}
	
	public EtapaFunil save(EtapaFunil etapaFunil) {
		return repoEtapaFunil.save(etapaFunil);
	}
	
	public List<EtapaFunil> saveAll(List<EtapaFunil> etapaFunil){
		return repoEtapaFunil.saveAll(etapaFunil);
	}
		
	public EtapaFunil edit (EtapaFunil etapaFunil) throws ObjectNotFoundException{
		EtapaFunil etapaFunilAntigo = search(etapaFunil.getId());   
		etapaFunilAntigo.setId(etapaFunil.getId());
		etapaFunilAntigo.setDescricao(etapaFunil.getDescricao());
		return save(etapaFunilAntigo);
	}	
	
	public void delete(Integer id) {
		repoEtapaFunil.deleteById(id);
	}	
	
}
