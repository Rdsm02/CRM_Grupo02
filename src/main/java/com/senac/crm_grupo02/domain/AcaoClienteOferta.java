package com.senac.crm_grupo02.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class AcaoClienteOferta implements Serializable{
	
	private static final long serialVersionUID = -6579966539493363449L;
	
	@Id
	@Column(name = "acao_cliente_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "acao_cliente_descricao")
	private String descricao;
	
	@Column(name = "acao_cliente_data")
	private String data;
	
	@Column(name = "acao_cliente_hora")
	private String hora;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "acao_id", nullable = false)
	private Acao acaoId;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente clienteId;	
	

	public Acao getAcaoId() {
		return acaoId;
	}

	public void setAcaoId(Acao acaoId) {
		this.acaoId = acaoId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}
	
}
