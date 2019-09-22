package com.senac.crm_grupo02.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Oferta implements Serializable{

	private static final long serialVersionUID = -6702828989756656592L;
	
	@Id
	@Column(name = "oferta_id")
	private Integer id;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "oferta_produto_id", nullable = false)
	private Produto produtoId;

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
/*
	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		String[] dataInicioFS = dataInicio.toString().split("-");		
		this.dataInicio = LocalDate.of(Integer.parseInt(dataInicioFS[0]), Integer.parseInt(dataInicioFS[1]), Integer.parseInt(dataInicioFS[2]));
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		String[] dataFimFS = dataFim.toString().split("-");
		this.dataFim = LocalDate.of(Integer.parseInt(dataFimFS[0]), Integer.parseInt(dataFimFS[1]), Integer.parseInt(dataFimFS[2]));
	}
*/
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

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
	}

}
