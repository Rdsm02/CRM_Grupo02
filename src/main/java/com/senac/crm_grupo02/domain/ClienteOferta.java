package com.senac.crm_grupo02.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@IdClass(ClienteOfertaId.class)
public class ClienteOferta implements Serializable{

	private static final long serialVersionUID = -4119377936067083997L;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
	private Cliente clienteId;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "oferta_id", nullable = false)
	private Oferta ofertaId;
	
	@Id
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "produto_id", nullable = true)
	private Produto produtoId;
	
	@Column(name = "cliente_oferta_preco")
	private double preco;
	
	@Column(name = "cliente_oferta_descricao")
	private String descricao;
	
	@Column(name = "cliente_oferta_status")
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "funil_Etapa_Id", nullable = false)
    @JsonIgnore
    private EtapaFunil funilEtapa;
	
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

}
