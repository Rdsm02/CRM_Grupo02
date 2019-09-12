package com.senac.crm_grupo02.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.senac.crm_grupo02.domain.Cliente;
import com.senac.crm_grupo02.service.ClienteService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	ClienteService servicoCliente;
	
	
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
		
		
		
		List<Cliente> listaDeClientes = new ArrayList<>();
		
		listaDeClientes.add(c1);
		listaDeClientes.add(c2);
		
		servicoCliente.saveAll(listaDeClientes);
		
	}

}
