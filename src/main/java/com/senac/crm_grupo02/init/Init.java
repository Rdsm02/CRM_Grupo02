package com.senac.crm_grupo02.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.senac.crm_grupo02.domain.Cliente;
import com.senac.crm_grupo02.domain.ClienteDadoTipo;
import com.senac.crm_grupo02.domain.ClienteDadoTipoCategoria;
import com.senac.crm_grupo02.domain.ClienteOferta;
import com.senac.crm_grupo02.domain.NivelInstrucao;
import com.senac.crm_grupo02.domain.Oferta;
import com.senac.crm_grupo02.domain.Produto;
import com.senac.crm_grupo02.service.ClienteDadoTipoCategoriaService;
import com.senac.crm_grupo02.service.ClienteDadoTipoService;
import com.senac.crm_grupo02.service.ClienteOfertaService;
import com.senac.crm_grupo02.service.ClienteService;
import com.senac.crm_grupo02.service.NivelInstrucaoService;
import com.senac.crm_grupo02.service.OfertaService;
import com.senac.crm_grupo02.service.ProdutoService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	ClienteService servicoCliente;
	
	@Autowired
	ProdutoService servicoProduto;
	
	@Autowired
	NivelInstrucaoService servicoNivelInstrucao;
	
	@Autowired
	OfertaService servicoOferta;
	
	@Autowired
	ClienteOfertaService servicoClienteOferta;
	
	@Autowired
	ClienteDadoTipoService servicoClienteDadoTipo;
	
	@Autowired
	ClienteDadoTipoCategoriaService servicoClienteDadoTipoCategoria;
	
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
		
		NivelInstrucao nI1 = new NivelInstrucao();
		nI1.setId(1);
		nI1.setDescricao("Graduação");
		nI1.setStatus("1");
		
		NivelInstrucao nI2 = new NivelInstrucao();
		nI2.setId(2);
		nI2.setDescricao("Especialização - MBA");
		nI2.setStatus("1");
		
		List<NivelInstrucao> listaDeNivelInstrucao = new ArrayList<>();
		
		listaDeNivelInstrucao.add(nI1);
		listaDeNivelInstrucao.add(nI2);
		
		servicoNivelInstrucao.saveAll(listaDeNivelInstrucao);
		
		
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
		
		List<Produto> listaDeProdutos = new ArrayList<>();
		
		listaDeProdutos.add(p1);
		listaDeProdutos.add(p2);		
		
		servicoProduto.saveAll(listaDeProdutos);
		
		
		//LocalDate dataInicio = LocalDate.of(2019, 7, 1);
		//LocalDate dataFim = LocalDate.of(2019, 12, 20);
		
		Oferta o1 = new Oferta();
		o1.setId(1);
		o1.setDescricao("2019.2n");
		o1.setDataInicio("2019-07-01");
		o1.setDataFim("2019-12-20");
		o1.setPreco(699.99);
		o1.setProdutoId(p1);
		o1.setStatus("1");
		
		List<Oferta> listaDeOfertas = new ArrayList<>();
		listaDeOfertas.add(o1);
		
		
		servicoOferta.saveAll(listaDeOfertas);
		
		System.out.println(servicoNivelInstrucao.searchAll());		
		
		
		
		ClienteOferta clienteOferta = new ClienteOferta();
		clienteOferta.setClienteId(listaDeClientes.get(0));
		clienteOferta.setProdutoId(listaDeProdutos.get(0));
		clienteOferta.setOfertaId(listaDeOfertas.get(0));
		clienteOferta.setPreco(200.0);
		clienteOferta.setDescricao("Cliente possível de Compra");
		clienteOferta.setStatus("1");
		
		List<ClienteOferta> listaDeClienteOferta = new ArrayList<>();
		listaDeClienteOferta.add(clienteOferta);
		
		//servicoClienteOferta.saveAll(listaDeClienteOferta);
		
		ClienteDadoTipoCategoria endereco = new ClienteDadoTipoCategoria();
		endereco.setCodigo(0);
		endereco.setDescricao("Endereco");
		endereco.setStatus("ativo");
		
		ClienteDadoTipoCategoria contato = new ClienteDadoTipoCategoria();
		contato.setCodigo(1);
		contato.setDescricao("Contato");
		contato.setStatus("ativo");
		
		List<ClienteDadoTipoCategoria> listaDeClienteDadoTipoCategoria = new ArrayList<>();
		listaDeClienteDadoTipoCategoria.add(endereco);
		listaDeClienteDadoTipoCategoria.add(contato);
		servicoClienteDadoTipoCategoria.saveAll(listaDeClienteDadoTipoCategoria);
		
		
		
		ClienteDadoTipo cep = new ClienteDadoTipo();
		cep.setCodigo(null);
		cep.setDescricao("CEP");
		cep.setStatus("Ativo");	
		cep.setObrigatorio(1);
		cep.setPadrao(1);
		cep.setMascara("00000-000");
		cep.setCliente_dado_tipo_categoria(endereco);		
		
		ClienteDadoTipo rua = new ClienteDadoTipo();
		rua.setCodigo(null);
		rua.setDescricao("Rua");
		rua.setStatus("Ativo");	
		rua.setObrigatorio(1);
		rua.setPadrao(1);
		rua.setMascara("SSSS");
		rua.setCliente_dado_tipo_categoria(endereco);
		
		ClienteDadoTipo telefone = new ClienteDadoTipo();
		telefone.setCodigo(null);
		telefone.setDescricao("Telefone");
		telefone.setStatus("Ativo");	
		telefone.setObrigatorio(1);
		telefone.setPadrao(1);
		telefone.setMascara("(00) 0 0000-0000");
		telefone.setCliente_dado_tipo_categoria(contato);
		
		ClienteDadoTipo email = new ClienteDadoTipo();
		email.setCodigo(null);
		email.setDescricao("email");
		email.setStatus("Ativo");	
		email.setObrigatorio(1);
		email.setPadrao(1);
		email.setMascara("SSSS");
		email.setCliente_dado_tipo_categoria(contato);
		
		List<ClienteDadoTipo> listaDeClienteDadoTipo = new ArrayList<>();
		listaDeClienteDadoTipo.add(cep);
		listaDeClienteDadoTipo.add(rua);
		listaDeClienteDadoTipo.add(telefone);
		listaDeClienteDadoTipo.add(email);
		
		servicoClienteDadoTipo.saveAll(listaDeClienteDadoTipo);
		
	}

}
