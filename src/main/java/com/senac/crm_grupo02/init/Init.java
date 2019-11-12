package com.senac.crm_grupo02.init;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.senac.crm_grupo02.domain.Acao;
import com.senac.crm_grupo02.domain.AcaoCliente;
import com.senac.crm_grupo02.domain.Cliente;
import com.senac.crm_grupo02.domain.ClienteDadoTipo;
import com.senac.crm_grupo02.domain.ClienteDadoTipoCategoria;
import com.senac.crm_grupo02.domain.ClienteOferta;
import com.senac.crm_grupo02.domain.EtapaFunil;
import com.senac.crm_grupo02.domain.NivelInstrucao;
import com.senac.crm_grupo02.domain.Oferta;
import com.senac.crm_grupo02.domain.Produto;
import com.senac.crm_grupo02.service.AcaoClienteService;
import com.senac.crm_grupo02.service.AcaoService;
import com.senac.crm_grupo02.service.ClienteDadoTipoCategoriaService;
import com.senac.crm_grupo02.service.ClienteDadoTipoService;
import com.senac.crm_grupo02.service.ClienteOfertaService;
import com.senac.crm_grupo02.service.ClienteService;
import com.senac.crm_grupo02.service.EtapaFunilService;
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
	
	@Autowired
	AcaoService acaoService;
	
	@Autowired
	AcaoClienteService acaoClienteService;	
	
	@Autowired
	EtapaFunilService servicoEtapaFunil;
	
	
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
		nI2.setStatus("0");
		
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
		
		ClienteDadoTipoCategoria principal = new ClienteDadoTipoCategoria();
		principal.setCodigo(null);
		principal.setDescricao("Principal");
		principal.setStatus("1");
		
		ClienteDadoTipoCategoria endereco = new ClienteDadoTipoCategoria();
		endereco.setCodigo(null);
		endereco.setDescricao("Endereco");
		endereco.setStatus("1");
		
		ClienteDadoTipoCategoria contato = new ClienteDadoTipoCategoria();
		contato.setCodigo(null);
		contato.setDescricao("Contato");
		contato.setStatus("1");
		
		List<ClienteDadoTipoCategoria> listaDeClienteDadoTipoCategoria = new ArrayList<>();
		listaDeClienteDadoTipoCategoria.add(principal);
		listaDeClienteDadoTipoCategoria.add(endereco);
		listaDeClienteDadoTipoCategoria.add(contato);
		servicoClienteDadoTipoCategoria.saveAll(listaDeClienteDadoTipoCategoria);
		
		ClienteDadoTipo cpf = new ClienteDadoTipo();
		cpf.setCodigo(null);
		cpf.setDescricao("CPF");
		cpf.setStatus("1");	
		cpf.setObrigatorio(1);
		cpf.setPadrao(1);
		cpf.setMascara("000.000.000-00");
		cpf.setCliente_dado_tipo_categoria(principal);

		ClienteDadoTipo nome = new ClienteDadoTipo();
		nome.setCodigo(null);
		nome.setDescricao("Nome");
		nome.setStatus("1");	
		nome.setObrigatorio(1);
		nome.setPadrao(1);
		nome.setMascara("0");
		nome.setCliente_dado_tipo_categoria(principal);

		ClienteDadoTipo sobrenome = new ClienteDadoTipo();
		sobrenome.setCodigo(null);
		sobrenome.setDescricao("Sobrenome");
		sobrenome.setStatus("1");	
		sobrenome.setObrigatorio(1);
		sobrenome.setPadrao(1);
		sobrenome.setMascara("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		sobrenome.setCliente_dado_tipo_categoria(principal);
		
		ClienteDadoTipo cep = new ClienteDadoTipo();
		cep.setCodigo(null);
		cep.setDescricao("CEP");
		cep.setStatus("1");	
		cep.setObrigatorio(1);
		cep.setPadrao(1);
		cep.setMascara("00000-000");
		cep.setCliente_dado_tipo_categoria(endereco);		
		
		ClienteDadoTipo rua = new ClienteDadoTipo();
		rua.setCodigo(null);
		rua.setDescricao("Rua");
		rua.setStatus("1");	
		rua.setObrigatorio(1);
		rua.setPadrao(1);
		rua.setMascara("SSSS");
		rua.setCliente_dado_tipo_categoria(endereco);
		
		ClienteDadoTipo telefone = new ClienteDadoTipo();
		telefone.setCodigo(null);
		telefone.setDescricao("Telefone");
		telefone.setStatus("1");	
		telefone.setObrigatorio(1);
		telefone.setPadrao(1);
		telefone.setMascara("00 0 0000-0000");
		telefone.setCliente_dado_tipo_categoria(contato);
		
		ClienteDadoTipo email = new ClienteDadoTipo();
		email.setCodigo(null);
		email.setDescricao("email");
		email.setStatus("1");	
		email.setObrigatorio(1);
		email.setPadrao(1);
		email.setMascara("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
		email.setCliente_dado_tipo_categoria(contato);
		
		List<ClienteDadoTipo> listaDeClienteDadoTipo = new ArrayList<>();
		listaDeClienteDadoTipo.add(cpf);
		listaDeClienteDadoTipo.add(nome);
		listaDeClienteDadoTipo.add(sobrenome);
		listaDeClienteDadoTipo.add(cep);
		listaDeClienteDadoTipo.add(rua);
		listaDeClienteDadoTipo.add(telefone);
		listaDeClienteDadoTipo.add(email);
		
		servicoClienteDadoTipo.saveAll(listaDeClienteDadoTipo);
		
		Acao acao1 = new Acao();
		acao1.setDescricao("Atendimento Telefônico");
		acao1.setStatus("1");
		acaoService.save(acao1);
		
		AcaoCliente acaoCliente1 = new AcaoCliente();
		acaoCliente1.setClienteId(c1);
		acaoCliente1.setAcaoId(acao1);
		acaoCliente1.setDescricao("Tentativa frustada de entrar em contato com cliente");
		acaoCliente1.setData("2019-10-25");
		acaoCliente1.setHora("13:00");
		acaoClienteService.save(acaoCliente1);
		
		EtapaFunil etapaFunil1 = new EtapaFunil();
		etapaFunil1.setId(null);
		etapaFunil1.setDescricao("Iniciante");
		etapaFunil1.setStatus("1");
		
		servicoEtapaFunil.save(etapaFunil1);
		
		
	}

}
