package com.senac.crm_grupo02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.NivelInstrucao;
import com.senac.crm_grupo02.repository.NivelInstrucaoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class NivelInstrucaoService {
	
	@Autowired
	NivelInstrucaoRepository repoNivelInstrucao;
	
	public NivelInstrucao search(Integer id) throws ObjectNotFoundException{
		Optional<NivelInstrucao> nivelInstrucao = repoNivelInstrucao.findById(id);
		return nivelInstrucao.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + NivelInstrucao.class.getName()));		
	}
	
	public List<NivelInstrucao> searchAll(){
		return repoNivelInstrucao.findAll();
	}
	
	public NivelInstrucao save(NivelInstrucao nivelInstrucao) {
		return repoNivelInstrucao.save(nivelInstrucao);
	}
	
	public List<NivelInstrucao> saveAll(List<NivelInstrucao> nivelInstrucoes){
		return repoNivelInstrucao.saveAll(nivelInstrucoes);
	}
	
	public NivelInstrucao edit (NivelInstrucao nivelInstrucao) throws ObjectNotFoundException{
		NivelInstrucao nivelInstrucaoAntigo = search(nivelInstrucao.getId());
		nivelInstrucaoAntigo.setId(nivelInstrucao.getId());
		nivelInstrucaoAntigo.setDescricao(nivelInstrucao.getDescricao());
		nivelInstrucaoAntigo.setStatus(nivelInstrucao.getStatus());		
		return save(nivelInstrucaoAntigo);
	}
	
	public void delete(Integer id) {
		repoNivelInstrucao.deleteById(id);
	}

}

