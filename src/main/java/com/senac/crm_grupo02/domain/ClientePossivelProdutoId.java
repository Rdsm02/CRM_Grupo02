package com.senac.crm_grupo02.domain;

import java.io.Serializable;

public class ClientePossivelProdutoId implements Serializable{

	private static final long serialVersionUID = -5161608430296011467L;
	
	private Produto produtoId;
	private Cliente clienteId;
	
	public Produto getProdutoId() {
		return produtoId;
	}
	public void setProdutoId(Produto produtoId) {
		this.produtoId = produtoId;
	}
	public Cliente getClienteId() {
		return clienteId;
	}
	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}
	
	

}
