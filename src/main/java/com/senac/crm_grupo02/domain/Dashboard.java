package com.senac.crm_grupo02.domain;

import java.math.BigDecimal;

public class Dashboard {
	
	private int idAcao;
	private String descricaoAcao;
	private int quantidadeDeAcao;
	private BigDecimal percentual;
	
	public int getIdAcao() {
		return idAcao;
	}
	public void setIdAcao(int idAcao) {
		this.idAcao = idAcao;
	}
	public String getDescricaoAcao() {
		return descricaoAcao;
	}
	public void setDescricaoAcao(String descricaoAcao) {
		this.descricaoAcao = descricaoAcao;
	}
	public int getQuantidadeDeAcao() {
		return quantidadeDeAcao;
	}
	public void setQuantidadeDeAcao(int quantidadeDeAcao) {
		this.quantidadeDeAcao = quantidadeDeAcao;
	}
	public BigDecimal getPercentual() {
		return percentual;
	}
	public void setPercentual(BigDecimal percentual) {
		this.percentual = percentual;
	}

}
