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
public class ClienteDado implements Serializable {

	private static final long serialVersionUID = 1713767193765888826L;

	@Id
	@Column(name = "cliente_dado_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Column(name = "cliente_dado_status")
	private String status;

	@Column(name = "cliente_dado_descricao")
	private String descricao;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cliente_id", nullable = false)
	private Cliente clienteId;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cliente_dado_tipo_id", nullable = false)
	private ClienteDadoTipo clienteDadoTipoId;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public Cliente getClienteId() {
		return clienteId;
	}

	public void setClienteId(Cliente clienteId) {
		this.clienteId = clienteId;
	}

	public ClienteDadoTipo getClienteDadoTipoId() {
		return clienteDadoTipoId;
	}

	public void setClienteDadoTipoId(ClienteDadoTipo clienteDadoTipoId) {
		this.clienteDadoTipoId = clienteDadoTipoId;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}
