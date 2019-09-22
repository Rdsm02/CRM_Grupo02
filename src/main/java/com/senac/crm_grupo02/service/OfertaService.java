package com.senac.crm_grupo02.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.Oferta;
import com.senac.crm_grupo02.repository.OfertaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class OfertaService {
	
	@Autowired
	OfertaRepository repoOferta;
	
	/*
	 * public Oferta procurarPorId(Integer id) { Optional<Oferta> oferta =
	 * repoOferta.findById(id);
	 * 
	 * 
	 * }
	 */
	
	public Oferta search(Integer id) throws ObjectNotFoundException{
		Optional<Oferta> oferta = repoOferta.findById(id);
		return oferta.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + Oferta.class.getName()));		
	}
	
	public List<Oferta> searchAll(){
		return repoOferta.findAll();
	}
	
	public Oferta save(Oferta oferta) {
		/*String[] dataInicioFS = oferta.getDataInicio().toString().split("-");
		String[] dataFimFS = oferta.getDataFim().toString().split("-");
		oferta.setDataInicio(LocalDate.of(Integer.parseInt(dataInicioFS[0]), Integer.parseInt(dataInicioFS[1]), Integer.parseInt(dataInicioFS[2])));
		oferta.setDataFim(LocalDate.of(Integer.parseInt(dataFimFS[0]), Integer.parseInt(dataFimFS[1]), Integer.parseInt(dataFimFS[2])));*/
		return repoOferta.save(oferta);
	}
	
	public List<Oferta> saveAll(List<Oferta> ofertas){
		return repoOferta.saveAll(ofertas);
	}
	
	public Oferta edit (Oferta oferta) throws ObjectNotFoundException{
		Oferta ofertaAntiga = search(oferta.getId());
		ofertaAntiga.setId(oferta.getId());
		ofertaAntiga.setDescricao(oferta.getDescricao());
		ofertaAntiga.setDataInicio(oferta.getDataInicio().toString());
		ofertaAntiga.setDataInicio(oferta.getDataFim().toString());
		ofertaAntiga.setPreco(oferta.getPreco());
		ofertaAntiga.setProdutoId(oferta.getProdutoId());		
		ofertaAntiga.setStatus(oferta.getStatus());		
		return save(ofertaAntiga);
	}
	
	public void delete(Integer id) {
		repoOferta.deleteById(id);
	}

}
