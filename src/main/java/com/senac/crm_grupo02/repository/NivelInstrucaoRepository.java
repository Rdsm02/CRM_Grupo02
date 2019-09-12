package com.senac.crm_grupo02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.crm_grupo02.domain.NivelInstrucao;

@Repository
public interface NivelInstrucaoRepository extends JpaRepository<NivelInstrucao, Integer>{

}
