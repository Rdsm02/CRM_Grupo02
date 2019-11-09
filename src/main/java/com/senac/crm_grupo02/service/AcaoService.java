package com.senac.crm_grupo02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.Acao;
import com.senac.crm_grupo02.repository.AcaoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AcaoService {
	
	@Autowired
	AcaoRepository repoAcao;
	
	public Acao search(Integer id) throws ObjectNotFoundException{
		Optional<Acao> acao = repoAcao.findById(id);
		return acao.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + Acao.class.getName()));		
	}
	
	public List<Acao> searchAll(){
		return repoAcao.findAll();
	}
	
	public Acao save(Acao acao) {
		acao.setId(null);
		return repoAcao.save(acao);
	}
	
	public List<Acao> saveAll(List<Acao> acaos){
		return repoAcao.saveAll(acaos);
	}
	
	public Acao edit (Acao acao) throws ObjectNotFoundException{
		Acao AcaoAntigo = search(acao.getId());
		AcaoAntigo.setId(acao.getId());
		AcaoAntigo.setDescricao(acao.getDescricao());
		AcaoAntigo.setStatus(acao.getStatus());
		return repoAcao.save(AcaoAntigo);
	}
	
	public void delete(Integer id) {
		repoAcao.deleteById(id);
	}

}
