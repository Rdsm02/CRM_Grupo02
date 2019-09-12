package com.senac.crm_grupo02.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ClientePossivelProduto implements Serializable{

	private static final long serialVersionUID = -6251109573639808327L;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "produto_id", nullable = false)
	private Produto produtoId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
	private Cliente clienteId;
	
	@Column(name = "cliente_possivel_produto_status")
	private String clientePossivelProdutoStatus;
	
	@Column(name = "cliente_possivel_produto_data")
	private Date clientePossivelProdutoData;
	
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
	public String getClientePossivelProdutoStatus() {
		return clientePossivelProdutoStatus;
	}
	public void setClientePossivelProdutoStatus(String clientePossivelProdutoStatus) {
		this.clientePossivelProdutoStatus = clientePossivelProdutoStatus;
	}
	public Date getClientePossivelProdutoData() {
		return clientePossivelProdutoData;
	}
	public void setClientePossivelProdutoData(Date clientePossivelProdutoData) {
		this.clientePossivelProdutoData = clientePossivelProdutoData;
	}	

}
