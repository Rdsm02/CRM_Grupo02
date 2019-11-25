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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Oferta implements Serializable{

	private static final long serialVersionUID = -6702828989756656592L;
	
	@Id
	@Column(name = "oferta_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "oferta_codigo")
	private String codigo;
	
	@Column(name = "oferta_descricao")
	private String descricao;
	
	@Column(name = "oferta_data_inicio")
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private String dataInicio;
	
	@Column(name = "oferta_data_fim")
	//@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private String dataFim;
	
	@Column(name = "oferta_preco")
	private Double preco;
	
	@Column(name = "oferta_status")
	private String status;
	
	//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "oferta_produto_id", nullable = true)
	private Produto produtoId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public String getDataInicio() {
		return dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	/*
	 * @DateTimeFormat(pattern="dd-MM-YYYY") public Date getDataInicioFormatada() {
	 * return new Date(dataInicio); }
	 * 
	 * @DateTimeFormat(pattern="dd-MM-YYYY") public Date getDataFimFormatada() {
	 * return new Date(dataFim); }
	 */

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
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

}
