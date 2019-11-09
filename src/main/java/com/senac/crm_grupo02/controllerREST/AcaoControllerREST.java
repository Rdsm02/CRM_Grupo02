package com.senac.crm_grupo02.controllerREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.senac.crm_grupo02.domain.Acao;
import com.senac.crm_grupo02.service.AcaoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/acaoREST")
public class AcaoControllerREST {
	
	@Autowired
	AcaoService servicoAcao;

	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/cadastrarAcao", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Acao cadastrarCliente(@RequestBody Acao acao){
		
		servicoAcao.save(acao);
		
        return acao;
    }
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/editarAcao", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Acao editarAcao(@RequestBody Acao acao) throws ObjectNotFoundException{
		
		servicoAcao.edit(acao);
		
        return acao;
    }
}
