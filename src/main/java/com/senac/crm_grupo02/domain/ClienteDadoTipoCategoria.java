package com.senac.crm_grupo02.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ClienteDadoTipoCategoria implements Serializable {

	private static final long serialVersionUID = -6169445244840087862L;

	@Id
	@Column(name = "cliente_dado_tipo_categoria_id")
	private Integer codigo;

	@Column(name = "cliente_dado_tipo_categoria_descricao")
	private String descricao;

	@Column(name = "cliente_dado_tipo_categoria_status")
	private String status;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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
