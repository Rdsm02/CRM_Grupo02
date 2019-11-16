package com.senac.crm_grupo02.controllerREST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.senac.crm_grupo02.domain.ClienteDadoTipoCategoria;
import com.senac.crm_grupo02.service.ClienteDadoTipoCategoriaService;

import javassist.tools.rmi.ObjectNotFoundException;


@RestController
@RequestMapping("/clienteDadoTipoCategoriaREST")
public class ClienteDadoTipoCategoriaREST {
	
	@Autowired
	ClienteDadoTipoCategoriaService servicoClienteDadoTipoCategoria;
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/cadastrarCategoriaDadoCliente", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDadoTipoCategoria cadastrarCategoriaDadoCliente(@RequestBody ClienteDadoTipoCategoria categoriaCliente){
		
		ClienteDadoTipoCategoria cdtc = new ClienteDadoTipoCategoria();
		cdtc.setCodigo(categoriaCliente.getCodigo());
		cdtc.setDescricao(categoriaCliente.getDescricao());
		cdtc.setStatus(categoriaCliente.getStatus());

		servicoClienteDadoTipoCategoria.save(cdtc);
		
        return cdtc;
    }
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/editarCategoriaDadoCliente", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDadoTipoCategoria editarCategoriaDadoCliente(@RequestBody ClienteDadoTipoCategoria clienteDadoTipoCategoria) throws ObjectNotFoundException{	
		

		servicoClienteDadoTipoCategoria.edit(clienteDadoTipoCategoria);
		
        return clienteDadoTipoCategoria;
    }
	
	@RequestMapping(value = "/obterClienteDadoTipoCategoria", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDadoTipoCategoria>> obterClienteDadoTipoCategoria() throws ObjectNotFoundException {
		
		List<ClienteDadoTipoCategoria> listaClienteDadoTipoCategoria = new ArrayList<ClienteDadoTipoCategoria>();
		listaClienteDadoTipoCategoria = servicoClienteDadoTipoCategoria.searchAll();		
		Map<Integer, ClienteDadoTipoCategoria> listaClienteDadoTipoCategoriahas = new HashMap<Integer, ClienteDadoTipoCategoria>();
		int cont = 1;
		
		for (ClienteDadoTipoCategoria itemClienteDadoTipoCategoria : listaClienteDadoTipoCategoria) {							
			listaClienteDadoTipoCategoriahas.put(cont, itemClienteDadoTipoCategoria);	
			cont++;							
		}
		return new ResponseEntity<List<ClienteDadoTipoCategoria>>(new ArrayList<ClienteDadoTipoCategoria>(listaClienteDadoTipoCategoriahas.values()), HttpStatus.OK);		
	}

}
