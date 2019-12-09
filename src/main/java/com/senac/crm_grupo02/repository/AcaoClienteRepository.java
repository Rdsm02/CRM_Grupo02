package com.senac.crm_grupo02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senac.crm_grupo02.domain.AcaoCliente;
import com.senac.crm_grupo02.domain.Cliente;


@Repository
public interface AcaoClienteRepository extends JpaRepository<AcaoCliente, Integer>{
	
	List<AcaoCliente> findByClienteId(Cliente clienteId);
	
	@Query(value = 
			"SELECT A.ACAO_DESCRICAO, COUNT(A.ACAO_ID) FROM ACAO AS A " 
			+ "JOIN ACAO_CLIENTE AS AC ON " 
			+ "A.ACAO_ID = AC.ACAO_ID " 
			+ "WHERE A.ACAO_ID = :acaoId", nativeQuery = true)
	List<List<Object>> buscarQuantidadeDeAcoesAtribuidasParaOClientePorAcaoId(@Param("acaoId") Integer acaoId);
	

}
