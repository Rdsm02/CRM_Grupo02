package com.senac.crm_grupo02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.crm_grupo02.domain.ClienteOferta;
import com.senac.crm_grupo02.domain.ClienteOfertaId;

@Repository
public interface ClienteOfertaRepository extends JpaRepository<ClienteOferta, ClienteOfertaId>{
	


}
