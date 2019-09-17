package com.senac.crm_grupo02.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.senac.crm_grupo02.domain.Cliente;
import com.senac.crm_grupo02.domain.NivelInstrucao;
import com.senac.crm_grupo02.domain.Produto;
import com.senac.crm_grupo02.service.ClienteService;
import com.senac.crm_grupo02.service.NivelInstrucaoService;
import com.senac.crm_grupo02.service.ProdutoService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	ClienteService servicoCliente;
	
	@Autowired
	ProdutoService servicoProduto;
	
	@Autowired
	NivelInstrucaoService servicoNivelInstrucao;
	
	
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Cliente c1 = new Cliente();
		c1.setId(null);
		c1.setCpf("00000000021");
		c1.setNome("Loren");
		c1.setSobrenome("Ipsum");
		c1.setEmail("loremIpsum@gmail.com");
		c1.setStatus("1");
		
		Cliente c2 = new Cliente();
		c2.setId(null);
		c2.setCpf("11111111121");
		c2.setNome("Teste");
		c2.setSobrenome("Fulano");
		c2.setEmail("testeFulano@gmail.com");
		c2.setStatus("1");
		
		NivelInstrucao nI1 = new NivelInstrucao();
		nI1.setId(1);
		nI1.setDescricao("Graduação");
		nI1.setStatus("1");
		
		NivelInstrucao nI2 = new NivelInstrucao();
		nI2.setId(2);
		nI2.setDescricao("Especialização - MBA");
		nI2.setStatus("1");
		
		Produto p1 = new Produto();
		p1.setId(null);
		p1.setDescricao("Análise e Desenvolvimento de Sistemas");
		p1.setStatus("1");
		p1.setNivelInstrucao(nI1);
		
		Produto p2 = new Produto();
		p2.setId(null);
		p2.setDescricao("Redes de Computadores");
		p2.setStatus("1");
		p2.setNivelInstrucao(nI2);	
		
		System.out.println(servicoNivelInstrucao.searchAll());
		
		
		List<Cliente> listaDeClientes = new ArrayList<>();
		
		listaDeClientes.add(c1);
		listaDeClientes.add(c2);

		List<NivelInstrucao> listaDeNivelInstrucao = new ArrayList<>();
		
		listaDeNivelInstrucao.add(nI1);
		listaDeNivelInstrucao.add(nI2);
		
		List<Produto> listaDeProdutos = new ArrayList<>();
		
		listaDeProdutos.add(p1);
		listaDeProdutos.add(p2);		
		
		
		servicoCliente.saveAll(listaDeClientes);
		servicoNivelInstrucao.saveAll(listaDeNivelInstrucao);
		servicoProduto.saveAll(listaDeProdutos);
		
	}

}
