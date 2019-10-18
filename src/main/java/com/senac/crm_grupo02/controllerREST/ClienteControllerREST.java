package com.senac.crm_grupo02.controllerREST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

import com.senac.crm_grupo02.domain.ClienteDadoTipo;
import com.senac.crm_grupo02.domain.ClienteDadoTipoCategoria;
import com.senac.crm_grupo02.domain.ClienteDadoTipoRetornoCampoDinamico;
import com.senac.crm_grupo02.service.ClienteDadoTipoCategoriaService;
import com.senac.crm_grupo02.service.ClienteDadoTipoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/clienteREST")
public class ClienteControllerREST {
	
	@Autowired
	ClienteDadoTipoService servicoClienteDadoTipo;
	
	@Autowired
	ClienteDadoTipoCategoriaService servicoClienteDadoCategoriaTipo;	
	
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
        return dadosCliente;
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
