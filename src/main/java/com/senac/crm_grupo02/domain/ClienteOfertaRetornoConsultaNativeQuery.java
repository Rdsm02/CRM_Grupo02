package com.senac.crm_grupo02.domain;

import java.io.Serializable;

public class ClienteOfertaRetornoConsultaNativeQuery implements Serializable{

	private static final long serialVersionUID = 5381191299174748159L;

	private Cliente clienteId;
	private Oferta ofertaId;
	private Produto produtoId;
	private EtapaFunil funilEtapa;
	private double preco;
	private String descricao;
	private String status;
	
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
	public EtapaFunil getFunilEtapa() {
		return funilEtapa;
	}
	public void setFunilEtapa(EtapaFunil funilEtapa) {
		this.funilEtapa = funilEtapa;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

}
