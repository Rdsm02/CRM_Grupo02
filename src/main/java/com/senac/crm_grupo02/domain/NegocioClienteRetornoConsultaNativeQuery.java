package com.senac.crm_grupo02.domain;

import java.io.Serializable;

public class NegocioClienteRetornoConsultaNativeQuery implements Serializable{

	private static final long serialVersionUID = -1374121310328607732L;
	
	private String produtoDescricao;
	private String ofertaDescricao;
	private Double ofertaPreco;
	private Double clienteOfertaPreco;
	
	public String getProdutoDescricao() {
		return produtoDescricao;
	}
	public void setProdutoDescricao(String produtoDescricao) {
		this.produtoDescricao = produtoDescricao;
	}
	public String getOfertaDescricao() {
		return ofertaDescricao;
	}
	public void setOfertaDescricao(String ofertaDescricao) {
		this.ofertaDescricao = ofertaDescricao;
	}
	public Double getOfertaPreco() {
		return ofertaPreco;
	}
	public void setOfertaPreco(Double ofertaPreco) {
		this.ofertaPreco = ofertaPreco;
	}
	public Double getClienteOfertaPreco() {
		return clienteOfertaPreco;
	}
	public void setClienteOfertaPreco(Double clienteOfertaPreco) {
		this.clienteOfertaPreco = clienteOfertaPreco;
	}

}
