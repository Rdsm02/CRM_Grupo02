package com.senac.crm_grupo02.controllerREST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senac.crm_grupo02.domain.ClienteOferta;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/funilREST")
public class FunilControllerREST {
	
	@RequestMapping(value = "/obterClienteOfertaPorOfertaId", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteOferta>> obterClienteOfertaPorOfertaId() throws ObjectNotFoundException {
		List<ClienteOferta> clienteOfertaLista = new ArrayList<ClienteOferta>();
		//clienteOfertaLista = servicoClienteDadoCategoriaTipo.searchAll();		
		Map<Integer, ClienteOferta> clienteOferta = new HashMap<Integer, ClienteOferta>();
		int cont = 1;
		
		for (ClienteOferta clienteOfertaitem : clienteOfertaLista) {							
			clienteOferta.put(cont, clienteOfertaitem);	
			cont++;							
		}
		
		return new ResponseEntity<List<ClienteOferta>>(new ArrayList<ClienteOferta>(clienteOferta.values()), HttpStatus.OK);		
	}

}
