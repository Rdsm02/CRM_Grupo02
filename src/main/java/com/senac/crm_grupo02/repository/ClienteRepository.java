package com.senac.crm_grupo02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.senac.crm_grupo02.domain.CategoriasClienteRetornoConsultaNativeQuery;
import com.senac.crm_grupo02.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	Cliente findByCpf(String cpf);
	
	@Query(value = "SELECT \n" + 
			"CDTC.CLIENTE_DADO_TIPO_CATEGORIA_ID,\n" + 
			"CDTC.CLIENTE_DADO_TIPO_CATEGORIA_DESCRICAO,\n" + 
			"CDT.CLIENTE_DADO_TIPO_ID,\n" + 
			"CDT.CLIENTE_DADO_TIPO_DESCRICAO, \n" + 
			"CDT.CLIENTE_DADO_TIPO_MASCARA,\n" + 
			"CD.CLIENTE_DADO_ID,\n" + 
			"CD.CLIENTE_DADO_DESCRICAO \n" + 
			"FROM CLIENTE_DADO CD\n" + 
			"JOIN CLIENTE_DADO_TIPO CDT ON\n" + 
			"CDT.CLIENTE_DADO_TIPO_ID = CD.CLIENTE_DADO_TIPO_ID \n" + 
			"JOIN CLIENTE_DADO_TIPO_CATEGORIA CDTC ON\n" + 
			"CDTC.CLIENTE_DADO_TIPO_CATEGORIA_ID = CDT.CLIENTE_DADO_TIPO_CATEGORIA_ID " +
			"WHERE CD.CLIENTE_ID = :idCliente", nativeQuery = true)
	List<List<Object>> buscarCategoriasDadosClientePorId(@Param("idCliente") Integer idCliente);

}
