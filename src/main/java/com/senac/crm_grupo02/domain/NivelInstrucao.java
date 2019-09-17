package com.senac.crm_grupo02.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nivel_instrucao")
public class NivelInstrucao implements Serializable{

	private static final long serialVersionUID = -4127786941861389667L;
	
	@Id
	@Column(name = "nivel_instrucao_id")
	/*@GeneratedValue(strategy = GenerationType.IDENTITY)*/
	private Integer id;
	
	@Column(name = "nivel_instrucao_descricao")
	private String descricao;
	
	@Column(name = "nivel_instrucao_status")
	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
