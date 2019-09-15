package com.senac.crm_grupo02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senac.crm_grupo02.domain.ClienteOferta;
import com.senac.crm_grupo02.domain.ClienteOfertaId;

public interface ClienteOfertaRepository extends JpaRepository<ClienteOferta, ClienteOfertaId>{
	


}
