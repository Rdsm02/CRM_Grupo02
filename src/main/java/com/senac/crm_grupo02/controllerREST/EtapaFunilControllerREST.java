package com.senac.crm_grupo02.controllerREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(value = "/buscarQuantidadeClientesNasEtapasporEtapaFunilId", method = RequestMethod.GET)
	public ResponseEntity<Integer> buscarQuantidadeClientesNasEtapasporEtapaFunilId(@RequestParam("etapaFunilId") int etapaFunilId) throws ObjectNotFoundException {
						
		Integer valorFinal = servicoEtapaFunil.buscarQuantidadeClientesNasEtapasporEtapaFunilId(etapaFunilId);
		
		return new ResponseEntity<Integer>(valorFinal, HttpStatus.OK);
	}
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/cadastrarEtapaFunil", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public EtapaFunil cadastrarEtapaFunil(@RequestBody EtapaFunil etapaFunil) throws ObjectNotFoundException{	
		

		servicoEtapaFunil.save(etapaFunil);
		
        return etapaFunil;
    }
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/editarEtapaFunil", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public EtapaFunil editarEtapaFunil(@RequestBody EtapaFunil etapaFunil) throws ObjectNotFoundException{	
		

		servicoEtapaFunil.edit(etapaFunil);
		
        return etapaFunil;
    }
	

}
