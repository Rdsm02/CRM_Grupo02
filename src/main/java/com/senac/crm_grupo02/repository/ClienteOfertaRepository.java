package com.senac.crm_grupo02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.senac.crm_grupo02.domain.ClienteOferta;
import com.senac.crm_grupo02.domain.ClienteOfertaId;

@Repository
public interface ClienteOfertaRepository extends JpaRepository<ClienteOferta, ClienteOfertaId>{
	
	@Query(value = 
			"SELECT CO.FUNIL_ETAPA_ID, C.CLIENTE_NOME, CO.CLIENTE_OFERTA_PRECO, COUNT(ACAO_CLIENTE_ID), C.CLIENTE_ID "
			+ "FROM CLIENTE_OFERTA AS CO " 
			+ "JOIN CLIENTE AS C ON "
			+ "CO.CLIENTE_ID = C.CLIENTE_ID "
			+ "LEFT JOIN ACAO_CLIENTE_OFERTA AS ACO "
			+ "ON ACO.CLIENTE_ID = C.CLIENTE_ID "
			+ "WHERE OFERTA_ID = :ofertaId "
			+ "GROUP BY C.CLIENTE_NOME", nativeQuery = true)
	List<List<Object>> buscarClienteOfertaPorOfertaId(@Param("ofertaId") Integer ofertaId);	
	
	@Modifying
	@Transactional
	@Query(
	  value = "INSERT INTO "
	  		+ "CLIENTE_OFERTA "
	  		+ "(OFERTA_ID, PRODUTO_ID , CLIENTE_ID , FUNIL_ETAPA_ID, CLIENTE_OFERTA_DESCRICAO, CLIENTE_OFERTA_PRECO)"
	  		+ " VALUES (:ofertaId , :produtoId , :clienteId , :funil_etapa_id, :cliente_oferta_descricao, :cliente_oferta_preco)", nativeQuery = true)
	void atribuirClienteOferta(@Param("ofertaId") Integer ofertaId, @Param("produtoId") Integer produtoId, 
	  @Param("clienteId") Integer clienteId, @Param("funil_etapa_id") Integer funil_etapa_id, 
	  @Param("cliente_oferta_descricao") String cliente_oferta_descricao, 
	  @Param("cliente_oferta_preco") double cliente_oferta_preco);
	
	@Modifying
	@Transactional
	@Query(
	  value = "UPDATE CLIENTE_OFERTA "
	  		+ "SET FUNIL_ETAPA_ID = :funil_etapa_id "
	  		+ "WHERE OFERTA_ID = :ofertaId AND CLIENTE_ID = :clienteId", nativeQuery = true)
	void atualizarEtapaDoClienteOferta(@Param("ofertaId") Integer ofertaId, 
			@Param("clienteId") Integer clienteId, @Param("funil_etapa_id") Integer funil_etapa_id);

}