package com.senac.crm_grupo02.controllerREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.senac.crm_grupo02.domain.Oferta;
import com.senac.crm_grupo02.service.OfertaService;
import com.senac.crm_grupo02.service.ProdutoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/ofertaREST")
public class OfertaControllerREST {
	
	@Autowired
	OfertaService servicoOferta;
	
	@Autowired
	ProdutoService servicoProduto;
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/cadastrarOferta", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Oferta cadastrarOferta(@RequestBody Oferta oferta) throws ObjectNotFoundException{
		
		Oferta ofertaNova = new Oferta();
		ofertaNova.setId(oferta.getId());
		ofertaNova.setCodigo(oferta.getCodigo());
		ofertaNova.setDescricao(oferta.getDescricao());
		ofertaNova.setDataInicio(oferta.getDataInicio());
		ofertaNova.setDataFim(oferta.getDataFim());
		ofertaNova.setPreco(oferta.getPreco());
		ofertaNova.setStatus(oferta.getStatus());
		ofertaNova.setProdutoId(servicoProduto.search(oferta.getProdutoId().getId()));		

		servicoOferta.save(ofertaNova);
		
        return ofertaNova;
    }

}
