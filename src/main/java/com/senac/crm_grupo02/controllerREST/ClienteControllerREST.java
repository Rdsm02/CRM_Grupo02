package com.senac.crm_grupo02.controllerREST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.domain.CategoriasClienteRetornoConsultaNativeQuery;
import com.senac.crm_grupo02.domain.Cliente;
import com.senac.crm_grupo02.domain.ClienteDado;
import com.senac.crm_grupo02.domain.ClienteDadoTipo;
import com.senac.crm_grupo02.domain.ClienteDadoTipoCategoria;
import com.senac.crm_grupo02.domain.ClienteDadoTipoRetornoCampoDinamico;
import com.senac.crm_grupo02.service.ClienteDadoService;
import com.senac.crm_grupo02.service.ClienteDadoTipoCategoriaService;
import com.senac.crm_grupo02.service.ClienteDadoTipoService;
import com.senac.crm_grupo02.service.ClienteService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/clienteREST")
public class ClienteControllerREST {
	
	@Autowired
	ClienteDadoTipoService servicoClienteDadoTipo;
	
	@Autowired
	ClienteDadoTipoCategoriaService servicoClienteDadoCategoriaTipo;
	
	@Autowired
	ClienteService servicoCliente;
	
	@Autowired
	ClienteDadoService servicoClienteDado;
	
	@RequestMapping(value = "/clienteDadoTipoCategorias", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDadoTipoCategoria>> ObterDadoTipoClienteCategoria() throws ObjectNotFoundException {
		List<ClienteDadoTipoCategoria> clienteDadoTipoCategoriaLista = new ArrayList<ClienteDadoTipoCategoria>();
		clienteDadoTipoCategoriaLista = servicoClienteDadoCategoriaTipo.searchAll();		
		Map<Integer, ClienteDadoTipoCategoria> clienteDadoTipoCategoria = new HashMap<Integer, ClienteDadoTipoCategoria>();
		int cont = 1;
		
		for (ClienteDadoTipoCategoria ClienteDadoTipoCategoriaItem : clienteDadoTipoCategoriaLista) {							
			clienteDadoTipoCategoria.put(cont, ClienteDadoTipoCategoriaItem);	
			cont++;							
		}
		
		return new ResponseEntity<List<ClienteDadoTipoCategoria>>(new ArrayList<ClienteDadoTipoCategoria>(clienteDadoTipoCategoria.values()), HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/clienteDadoTipo", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDadoTipo>> ObterDadoTipo(@RequestParam("categoriaId") int categoriaId) throws ObjectNotFoundException {
		ClienteDadoTipoCategoria cdtc = new ClienteDadoTipoCategoria();
		cdtc = servicoClienteDadoCategoriaTipo.search(categoriaId);
		List<ClienteDadoTipo> clienteDadoTipoLista = new ArrayList<ClienteDadoTipo>();
		clienteDadoTipoLista = servicoClienteDadoTipo.searchAll();		
		Map<Integer, ClienteDadoTipo> clienteDadoTipo = new HashMap<Integer, ClienteDadoTipo>();
		int cont = 1;
		for (ClienteDadoTipo clienteDadoTipoItem : clienteDadoTipoLista) {			
			if ((clienteDadoTipoItem.getCliente_dado_tipo_categoria().getCodigo()) == cdtc.getCodigo()) {					
				clienteDadoTipo.put(cont, clienteDadoTipoItem);	
				cont++;
			}			
		}
		return new ResponseEntity<List<ClienteDadoTipo>>(new ArrayList<ClienteDadoTipo>(clienteDadoTipo.values()), HttpStatus.OK);		
	}
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/cadastrarCliente", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<ClienteDadoTipoRetornoCampoDinamico> cadastrarCliente(@RequestBody List<ClienteDadoTipoRetornoCampoDinamico> dadosCliente){
		Cliente c = new Cliente();
		System.out.println();
		c.setId(null);
		c.setCpf(dadosCliente.get(0).getValor().toString().replaceAll("[.-]", ""));
		c.setNome(dadosCliente.get(1).getValor().toString());
		c.setSobrenome(dadosCliente.get(2).getValor().toString());
		servicoCliente.save(c);
		
		c.setId(servicoCliente.buscarPorCpfRetornarIdCliente(c.getCpf()));
		ClienteDadoTipo cdt;
		try {
			
			
			for(int i = 3; i < dadosCliente.size(); i++) {				
			
			ClienteDado cd = new ClienteDado();
			cdt = servicoClienteDadoTipo.search(Integer.parseInt(dadosCliente.get(i).getIdCampo()));
			cd.setCodigo(null);
			cd.setStatus("1");
			cd.setDescricao(dadosCliente.get(i).getValor().toString().replaceAll("[.-]", ""));
			cd.setClienteId(c);
			cd.setClienteDadoTipoId(cdt);
			
			servicoClienteDado.save(cd);
			
			}
		} catch (NumberFormatException e) {
			Logger.getLogger("Erro");
			e.printStackTrace();
		} catch (ObjectNotFoundException e) {
			Logger.getLogger("Erro");
			e.printStackTrace();
		}
		
        return dadosCliente;
    }
	
	@RequestMapping(value = "/listarClientes", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listarClientes() throws ObjectNotFoundException {
		List<Cliente> clienteLista = new ArrayList<Cliente>();
		clienteLista = servicoCliente.searchAll();		
		Map<Integer, Cliente> clientehas = new HashMap<Integer, Cliente>();
		int cont = 1;
		
		for (Cliente ClienteItem : clienteLista) {							
			clientehas.put(cont, ClienteItem);	
			cont++;							
		}
		
		return new ResponseEntity<List<Cliente>>(new ArrayList<Cliente>(clientehas.values()), HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/listarClientePorId", method = RequestMethod.GET)
	public ResponseEntity<List<Cliente>> listarClientePorId(@RequestParam("clienteId") int clienteId) throws ObjectNotFoundException {
		Cliente cliente = new Cliente();
		cliente = servicoCliente.search(clienteId);		
		Map<Integer, Cliente> clientehas = new HashMap<Integer, Cliente>();
		clientehas.put(1, cliente);	
		
		return new ResponseEntity<List<Cliente>>(new ArrayList<Cliente>(clientehas.values()), HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/listarClientesDado", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDado>> listarClientesDado() throws ObjectNotFoundException {
		List<ClienteDado> clienteLista = new ArrayList<ClienteDado>();
		clienteLista = servicoClienteDado.searchAll();		
		Map<Integer, ClienteDado> clientehas = new HashMap<Integer, ClienteDado>();
		int cont = 1;
		
		for (ClienteDado ClienteDadoItem : clienteLista) {							
			clientehas.put(cont, ClienteDadoItem);	
			cont++;							
		}
		
		return new ResponseEntity<List<ClienteDado>>(new ArrayList<ClienteDado>(clientehas.values()), HttpStatus.OK);		
	}
	
	/*método nao usado no momento*/
	@RequestMapping(value = "/carregarDetalheCliente", method = RequestMethod.GET)
	public ModelAndView carregarDetalheCliente(@RequestParam("clienteId")  int clienteId) throws ObjectNotFoundException {
		ModelAndView mv = new ModelAndView("paginas/cliente/index");
		mv.addObject("clientesDetalhe", servicoCliente.search(clienteId));
		
		return mv;		
	}
	//TODO criar metodo para buscar todos os dados do cliente
	@RequestMapping(value = "/listarCategoriaClienteId", method = RequestMethod.GET)
	public ResponseEntity<List<Object>> listarCategoriaClienteId(@RequestParam("clienteId") int clienteId) throws ObjectNotFoundException {
		//CategoriasClienteRetornoConsultaNativeQuery ccrcnq = new CategoriasClienteRetornoConsultaNativeQuery();
		List<List<Object>> listaCategorias = new ArrayList<List<Object>>();
		listaCategorias = servicoCliente.buscarCategoriasDadosClientePorId(clienteId);	
		
		Map<Integer, CategoriasClienteRetornoConsultaNativeQuery> clienteCategoriahas = new HashMap<Integer, CategoriasClienteRetornoConsultaNativeQuery>();
		
		int cont = 1;
		
		for (List<Object> ClienteCategoriaLista: listaCategorias) {	
			CategoriasClienteRetornoConsultaNativeQuery ccrcnq = new CategoriasClienteRetornoConsultaNativeQuery();
			ccrcnq.setCliente_dado_tipo_categoria_id(Integer.parseInt(ClienteCategoriaLista.get(0).toString()));
			ccrcnq.setCliente_dado_tipo_categoria_descricao(ClienteCategoriaLista.get(1).toString());
			ccrcnq.setCliente_dado_tipo_id(Integer.parseInt(ClienteCategoriaLista.get(2).toString()));
			ccrcnq.setCliente_dado_tipo_descricao(ClienteCategoriaLista.get(3).toString());
			ccrcnq.setCliente_dado_tipo_mascara(ClienteCategoriaLista.get(4).toString());
			ccrcnq.setCliente_dado_id(Integer.parseInt(ClienteCategoriaLista.get(5).toString()));
			ccrcnq.setCliente_dado_descricao(ClienteCategoriaLista.get(6).toString());
			
			clienteCategoriahas.put(cont, ccrcnq);	
			cont++;							
		}	
		
		return new ResponseEntity<List<Object>>(new ArrayList<Object>(clienteCategoriahas.values()), HttpStatus.OK);		
	}
	
	@PostMapping(value = "/clienteTeste")
	public ResponseEntity<?> newBazz(@RequestParam("name") String name){
	    return new ResponseEntity<>(name, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/generateAddress", method = RequestMethod.POST)
	public ResponseEntity<String> generateAddress(@RequestBody String myJsonRequestComingIn) {
	    System.out.printf(myJsonRequestComingIn, myJsonRequestComingIn);
		return null;
	}
	
	@ResponseStatus(HttpStatus.OK)
    //Por padrão responde com o status code 200 success
    @RequestMapping(value ="/testeJson", method = RequestMethod.POST,
    //Mapeia as requisições POST para localhost:8080/person/
        consumes = MediaType.APPLICATION_JSON_VALUE)
        // Consome JSON enviado no corpo da requisição
    public List<ClienteDadoTipoRetornoCampoDinamico> update(@RequestBody List<ClienteDadoTipoRetornoCampoDinamico> person){
        return person;
    }

}
