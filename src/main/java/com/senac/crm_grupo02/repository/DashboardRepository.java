package com.senac.crm_grupo02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DashboardRepository {
	
	@Query(value = 
			"SELECT A.ACAO_DESCRICAO, COUNT(A.ACAO_ID) FROM ACAO AS A " 
			+ "JOIN ACAO_CLIENTE AS AC ON " 
			+ "A.ACAO_ID = AC.ACAO_ID " 
			+ "WHERE A.ACAO_ID = :acaoId", nativeQuery = true)
	List<List<Object>> buscarQuantidadeDeAcoesAtribuidasParaOClientePorAcaoId(@Param("acaoId") Integer acaoId);

}
