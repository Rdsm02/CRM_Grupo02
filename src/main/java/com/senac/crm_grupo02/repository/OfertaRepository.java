package com.senac.crm_grupo02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.crm_grupo02.domain.Oferta;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Integer>{

}
