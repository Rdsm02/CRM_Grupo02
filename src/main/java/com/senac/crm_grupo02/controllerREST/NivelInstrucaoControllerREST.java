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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.senac.crm_grupo02.domain.NivelInstrucao;
import com.senac.crm_grupo02.service.NivelInstrucaoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/nivelInstrucaoREST")
public class NivelInstrucaoControllerREST {
	
	@Autowired
	NivelInstrucaoService servicoNivelInstrucao;
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/cadastrarNivelInstrucao", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public NivelInstrucao cadastrarCliente(@RequestBody NivelInstrucao nivelInstrucao){
		
		servicoNivelInstrucao.save(nivelInstrucao);
		
        return nivelInstrucao;
    }
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/editarNivelInstrucao", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public NivelInstrucao editarNivelInstrucao(@RequestBody NivelInstrucao nivelInstrucao) throws ObjectNotFoundException{
		
		servicoNivelInstrucao.edit(nivelInstrucao);
		
        return nivelInstrucao;
    }
	
	@RequestMapping(value = "/obterNivelInstrucao", method = RequestMethod.GET)
	public ResponseEntity<List<NivelInstrucao>> obterNivelInstrucao() throws ObjectNotFoundException {
		
		List<NivelInstrucao> listaNivelInstrucao = new ArrayList<NivelInstrucao>();
		listaNivelInstrucao = servicoNivelInstrucao.searchAll();		
		Map<Integer, NivelInstrucao> listaNivelInstrucaohas = new HashMap<Integer, NivelInstrucao>();
		int cont = 1;
		
		for (NivelInstrucao itemNivelInstrucao : listaNivelInstrucao) {							
			listaNivelInstrucaohas.put(cont, itemNivelInstrucao);	
			cont++;							
		}
		return new ResponseEntity<List<NivelInstrucao>>(new ArrayList<NivelInstrucao>(listaNivelInstrucaohas.values()), HttpStatus.OK);		
	}
	
	@RequestMapping(value = "/obterNivelInstrucaoPorId", method = RequestMethod.GET)
	public ResponseEntity<NivelInstrucao> obterNivelInstrucao(@RequestParam("nivelInstrucao") int nivelInstrucao) throws ObjectNotFoundException {
		
		NivelInstrucao nI = servicoNivelInstrucao.search(nivelInstrucao);		
		
		return new ResponseEntity<NivelInstrucao>(nI, HttpStatus.OK);		
	}

}
