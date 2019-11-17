package com.senac.crm_grupo02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.crm_grupo02.domain.AcaoCliente;
import com.senac.crm_grupo02.domain.Cliente;


@Repository
public interface AcaoClienteRepository extends JpaRepository<AcaoCliente, Integer>{
	
	List<AcaoCliente> findByClienteId(Cliente clienteId);
	

}
