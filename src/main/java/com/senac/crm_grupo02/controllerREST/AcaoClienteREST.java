package com.senac.crm_grupo02.controllerREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.senac.crm_grupo02.domain.AcaoCliente;
import com.senac.crm_grupo02.domain.Produto;
import com.senac.crm_grupo02.service.AcaoClienteService;
import com.senac.crm_grupo02.service.AcaoService;
import com.senac.crm_grupo02.service.ClienteService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/AcaoClienteREST")
public class AcaoClienteREST {

	@Autowired
	AcaoClienteService servicoAcaoCliente;
	
	@Autowired
	ClienteService servicoCliente;
	
	@Autowired
	AcaoService servicoAcao;
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/cadastrarAcaoCliente", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AcaoCliente cadastrarCliente(@RequestBody AcaoCliente acaoCliente) throws ObjectNotFoundException{
		
		AcaoCliente acaoClienteNovo = new AcaoCliente();
		acaoClienteNovo.setId(acaoCliente.getId());
		acaoClienteNovo.setAcaoId(servicoAcao.search(acaoCliente.getAcaoId().getId()));
		acaoClienteNovo.setClienteId(servicoCliente.search(acaoCliente.getClienteId().getId()));
		acaoClienteNovo.setDescricao(acaoCliente.getDescricao());
		acaoClienteNovo.setData(acaoCliente.getData());
		acaoClienteNovo.setHora(acaoCliente.getHora());
		
		
		servicoAcaoCliente.save(acaoClienteNovo);
		
        return acaoClienteNovo;
    }
		

			
	
}
