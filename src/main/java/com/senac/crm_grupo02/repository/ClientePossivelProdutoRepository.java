package com.senac.crm_grupo02.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.senac.crm_grupo02.domain.ClientePossivelProduto;
import com.senac.crm_grupo02.domain.ClientePossivelProdutoId;

@Repository
public interface ClientePossivelProdutoRepository extends JpaRepository<ClientePossivelProduto, ClientePossivelProdutoId>{

}
