package com.senac.crm_grupo02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.crm_grupo02.domain.Oferta;
import com.senac.crm_grupo02.domain.Produto;

@Repository
public interface OfertaRepository extends JpaRepository<Oferta, Integer>{
	
	List<Oferta> findByProdutoId(Produto produtoId);

}
