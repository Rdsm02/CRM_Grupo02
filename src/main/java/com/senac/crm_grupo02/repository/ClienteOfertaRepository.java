package com.senac.crm_grupo02.repository;

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
	
	@Modifying
	@Query(
	  value = "INSERT INTO "
	  		+ "CLIENTE_OFERTA "
	  		+ "(OFERTA_ID, PRODUTO_ID , CLIENTE_ID , FUNIL_ETAPA_ID)"
	  		+ " VALUES (:ofertaId , :produtoId , :clienteId , :funil_etapa_id)", nativeQuery = true)
	@Transactional
	void atribuirClienteOferta(@Param("ofertaId") Integer ofertaId, @Param("produtoId") Integer produtoId, 
	  @Param("clienteId") Integer clienteId, @Param("funil_etapa_id") Integer funil_etapa_id);
	


}