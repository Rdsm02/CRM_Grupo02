package com.senac.crm_grupo02.domain;

import java.io.Serializable;

public class ClienteOfertaRetornoConsultaNativeQuery implements Serializable{

	private static final long serialVersionUID = 5381191299174748159L;

	private Integer idCliente;
	private int funilEtapa;
	private String clienteNome;
	private double clienteOfertaPreco;
	private int qtdAcoesClienteOferta;
	
	public int getFunilEtapa() {
		return funilEtapa;
	}
	public void setFunilEtapa(int funilEtapa) {
		this.funilEtapa = funilEtapa;
	}
	public String getClienteNome() {
		return clienteNome;
	}
	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}
	public double getClienteOfertaPreco() {
		return clienteOfertaPreco;
	}
	public void setClienteOfertaPreco(double clienteOfertaPreco) {
		this.clienteOfertaPreco = clienteOfertaPreco;
	}
	public int getQtdAcoesClienteOferta() {
		return qtdAcoesClienteOferta;
	}
	public void setQtdAcoesClienteOferta(int qtdAcoesClienteOferta) {
		this.qtdAcoesClienteOferta = qtdAcoesClienteOferta;
	}
	public Integer getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}
	
}
