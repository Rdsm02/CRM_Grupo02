package com.senac.crm_grupo02.domain;

public class CalculoPorcentagemGraficoBarras {
	
	private Integer idEtapa;
	private String nomeEtapa;
	private int valorTotalDeOfertasColuna;
	private Double porcentagem;	
	
	public Integer getIdEtapa() {
		return idEtapa;
	}
	public void setIdEtapa(Integer idEtapa) {
		this.idEtapa = idEtapa;
	}
	public String getNomeEtapa() {
		return nomeEtapa;
	}
	public void setNomeEtapa(String nomeEtapa) {
		this.nomeEtapa = nomeEtapa;
	}
	public int getValorTotalDeOfertasColuna() {
		return valorTotalDeOfertasColuna;
	}
	public void setValorTotalDeOfertasColuna(int valorTotalDeOfertasColuna) {
		this.valorTotalDeOfertasColuna = valorTotalDeOfertasColuna;
	}
	public Double getPorcentagem() {
		return porcentagem;
	}
	public void setPorcentagem(Double porcentagem) {
		this.porcentagem = porcentagem;
	}

}
