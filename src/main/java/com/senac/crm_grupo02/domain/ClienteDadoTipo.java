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
public class ClienteDadoTipo implements Serializable {

	private static final long serialVersionUID = 3463124992226391133L;

	@Id
	@Column(name = "cliente_dado_tipo_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Column(name = "cliente_dado_tipo_descricao")
	private String descricao;

	@Column(name = "cliente_dado_tipo_status")
	private String status;

	@Column(name = "cliente_dado_tipo_obrigatorio")
	private String obrigatorio;

	@Column(name = "cliente_dado_tipo_padrao")
	private String padrao;

	@Column(name = "cliente_dado_tipo_mascara")
	private String mascara;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "cliente_dado_tipo_categoria_id", nullable = false)
	// @JsonIgnore
	private ClienteDadoTipoCategoria cliente_dado_tipo_categoria;

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

	public String getObrigatorio() {
		return obrigatorio;
	}

	public void setObrigatorio(String obrigatorio) {
		this.obrigatorio = obrigatorio;
	}

	public String getPadrao() {
		return padrao;
	}

	public void setPadrao(String padrao) {
		this.padrao = padrao;
	}

	public String getMascara() {
		return mascara;
	}

	public void setMascara(String mascara) {
		this.mascara = mascara;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public ClienteDadoTipoCategoria getCliente_dado_tipo_categoria() {
		return cliente_dado_tipo_categoria;
	}

	public void setCliente_dado_tipo_categoria(ClienteDadoTipoCategoria cliente_dado_tipo_categoria) {
		this.cliente_dado_tipo_categoria = cliente_dado_tipo_categoria;
	}

}
