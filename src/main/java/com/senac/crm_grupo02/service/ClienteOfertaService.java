package com.senac.crm_grupo02.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.ClienteOferta;
import com.senac.crm_grupo02.domain.ClienteOfertaId;
import com.senac.crm_grupo02.domain.NegocioClienteRetornoConsultaNativeQuery;
import com.senac.crm_grupo02.repository.ClienteOfertaRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ClienteOfertaService {

	@Autowired
	ClienteOfertaRepository repoClienteOferta;
	
	public List<NegocioClienteRetornoConsultaNativeQuery> buscarNegociosporClienteId(Integer clienteId) {
		List<List<Object>> listaNegocioCliente = new ArrayList<List<Object>>();
		listaNegocioCliente = repoClienteOferta.buscarNegociosporClienteId(clienteId);
		
		List<NegocioClienteRetornoConsultaNativeQuery> listaNegocioClienteNativeQuery = new ArrayList<>();
		
		for (List<Object> listaClienteOfertaItem: listaNegocioCliente) {	
			NegocioClienteRetornoConsultaNativeQuery ncrcnq = new NegocioClienteRetornoConsultaNativeQuery();
			
			ncrcnq.setProdutoDescricao(listaClienteOfertaItem.get(0).toString());
			ncrcnq.setOfertaDescricao(listaClienteOfertaItem.get(1).toString());
			ncrcnq.setOfertaPreco(Double.parseDouble(listaClienteOfertaItem.get(2).toString()));
			ncrcnq.setClienteOfertaPreco(Double.parseDouble(listaClienteOfertaItem.get(3).toString()));
			
			listaNegocioClienteNativeQuery.add(ncrcnq);
										
		}	
		return listaNegocioClienteNativeQuery;
	}
	
	public void atualizarEtapaDoClienteOferta(Integer ofertaId, Integer clienteId, Integer funil_etapa_id) {
		repoClienteOferta.atualizarEtapaDoClienteOferta(ofertaId, clienteId, funil_etapa_id);
	}
	
	public void atribuirClienteOferta(Integer ofertaId, Integer produtoId, Integer clienteId, Integer funil_etapa_id, String cliente_oferta_descricao, double cliente_oferta_preco) {
		repoClienteOferta.atribuirClienteOferta(ofertaId, produtoId, clienteId, funil_etapa_id, cliente_oferta_descricao, cliente_oferta_preco);		
	}
	
	public List<List<Object>> buscarClienteOfertaPorOfertaId(Integer ofertaId){
		return repoClienteOferta.buscarClienteOfertaPorOfertaId(ofertaId);
	}

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
