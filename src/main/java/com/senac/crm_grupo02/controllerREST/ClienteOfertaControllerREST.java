package com.senac.crm_grupo02.controllerREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.senac.crm_grupo02.domain.ClienteOferta;
import com.senac.crm_grupo02.service.ClienteOfertaService;
import com.senac.crm_grupo02.service.ClienteService;
import com.senac.crm_grupo02.service.EtapaFunilService;
import com.senac.crm_grupo02.service.OfertaService;
import com.senac.crm_grupo02.service.ProdutoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/clienteClienteOfertaREST")
public class ClienteOfertaControllerREST {
	
	@Autowired
	ClienteOfertaService servicoClienteOferta;

	@Autowired
	ClienteService servicoCliente;
	
	@Autowired
	OfertaService servicoOferta;
	
	@Autowired
	EtapaFunilService servicoEtapaFunil;
	
	@Autowired
	ProdutoService servicoProduto;
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/cadastrarClienteOferta", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClienteOferta cadastrarClienteOferta(@RequestBody ClienteOferta clienteOferta) throws ObjectNotFoundException{
		
		ClienteOferta clienteOfertaNova = new ClienteOferta();
		clienteOfertaNova.setClienteId(servicoCliente.search(clienteOferta.getClienteId().getId()));
		clienteOfertaNova.setOfertaId(servicoOferta.search(clienteOferta.getOfertaId().getId()));
		clienteOfertaNova.setProdutoId(clienteOfertaNova.getOfertaId().getProdutoId());
		clienteOfertaNova.setFunilEtapa(servicoEtapaFunil.search(clienteOferta.getFunilEtapa().getId()));

		servicoClienteOferta.save(clienteOfertaNova);
		
        return clienteOfertaNova;
    }
	
	

}
