package com.senac.crm_grupo02.domain;

import java.io.Serializable;

public class ClienteOfertaId implements Serializable{

	private static final long serialVersionUID = 3666966063629828570L;

	private Cliente clienteId;
	private Oferta ofertaId;
	private Produto produtoId;
	
	public Cliente getClienteId() {
		return clienteId;
	}
	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}
	public Oferta getOfertaId() {
		return ofertaId;
	}
	public void setOfertaId(Oferta ofertaId) {
		this.ofertaId = ofertaId;
	}
	public Produto getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Produto produtoId) {
		this.produtoId = produtoId;
	}
	
	
}
