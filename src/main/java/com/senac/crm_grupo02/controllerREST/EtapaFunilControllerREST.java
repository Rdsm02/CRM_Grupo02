package com.senac.crm_grupo02.controllerREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.senac.crm_grupo02.domain.EtapaFunil;
import com.senac.crm_grupo02.service.EtapaFunilService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/etapaFunilREST")
public class EtapaFunilControllerREST {
	
	@Autowired
	EtapaFunilService servicoEtapaFunil;
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/cadastrarEtapaFnunil", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public EtapaFunil cadastrarEtapaFnunil(@RequestBody EtapaFunil etapaFunil) throws ObjectNotFoundException{	
		

		servicoEtapaFunil.save(etapaFunil);
		
        return etapaFunil;
    }
	

}
