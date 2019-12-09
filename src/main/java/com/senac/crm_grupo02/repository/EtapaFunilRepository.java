package com.senac.crm_grupo02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.senac.crm_grupo02.domain.EtapaFunil;

public interface EtapaFunilRepository extends JpaRepository<EtapaFunil, Integer>{

	@Query(value ="SELECT COUNT(EF.ETAPA_FUNIL_ID) FROM ETAPA_FUNIL  AS EF " 
			+ "JOIN CLIENTE_OFERTA AS CO ON "
			+ "EF.ETAPA_FUNIL_ID = CO.FUNIL_ETAPA_ID "
			+ "WHERE EF.ETAPA_FUNIL_ID = :etapaFunilId", nativeQuery = true)
	Integer buscarQuantidadeClientesNasEtapasporEtapaFunilId(@Param("etapaFunilId") Integer etapaFunilId);
	
}
