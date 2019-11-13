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
public class Produto implements Serializable{

	private static final long serialVersionUID = 6959855640644145440L;

	@Id
	@Column(name = "produto_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "produto_descricao")
	private String descricao;
	
	@Column(name = "produto_status")
	private String status;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nivel_instrucao_id", nullable = false)
	private NivelInstrucao nivelInstrucao;

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

	public NivelInstrucao getNivelInstrucao() {
		return nivelInstrucao;
	}

	public void setNivelInstrucao(NivelInstrucao nivelInstrucao) {
		this.nivelInstrucao = nivelInstrucao;
	}	
	

}
