package com.senac.crm_grupo02.domain;

import java.io.Serializable;

public class CategoriasClienteRetornoConsultaNativeQuery implements Serializable{

	private static final long serialVersionUID = 3865594236222977773L;
	
	private Integer cliente_dado_tipo_categoria_id;
	private String cliente_dado_tipo_categoria_descricao;
	private Integer cliente_dado_tipo_id;
	private String cliente_dado_tipo_descricao;
	private String cliente_dado_tipo_mascara;
	private Integer cliente_dado_id;
	private String cliente_dado_descricao;
	
	
	public Integer getCliente_dado_tipo_categoria_id() {
		return cliente_dado_tipo_categoria_id;
	}
	public void setCliente_dado_tipo_categoria_id(Integer cliente_dado_tipo_categoria_id) {
		this.cliente_dado_tipo_categoria_id = cliente_dado_tipo_categoria_id;
	}
	public String getCliente_dado_tipo_categoria_descricao() {
		return cliente_dado_tipo_categoria_descricao;
	}
	public void setCliente_dado_tipo_categoria_descricao(String cliente_dado_tipo_categoria_descricao) {
		this.cliente_dado_tipo_categoria_descricao = cliente_dado_tipo_categoria_descricao;
	}
	public Integer getCliente_dado_tipo_id() {
		return cliente_dado_tipo_id;
	}
	public void setCliente_dado_tipo_id(Integer cliente_dado_tipo_id) {
		this.cliente_dado_tipo_id = cliente_dado_tipo_id;
	}
	public String getCliente_dado_tipo_descricao() {
		return cliente_dado_tipo_descricao;
	}
	public void setCliente_dado_tipo_descricao(String cliente_dado_tipo_descricao) {
		this.cliente_dado_tipo_descricao = cliente_dado_tipo_descricao;
	}
	public String getCliente_dado_tipo_mascara() {
		return cliente_dado_tipo_mascara;
	}
	public void setCliente_dado_tipo_mascara(String cliente_dado_tipo_mascara) {
		this.cliente_dado_tipo_mascara = cliente_dado_tipo_mascara;
	}
	public Integer getCliente_dado_id() {
		return cliente_dado_id;
	}
	public void setCliente_dado_id(Integer cliente_dado_id) {
		this.cliente_dado_id = cliente_dado_id;
	}
	public String getCliente_dado_descricao() {
		return cliente_dado_descricao;
	}
	public void setCliente_dado_descricao(String cliente_dado_descricao) {
		this.cliente_dado_descricao = cliente_dado_descricao;
	}	
	
}
