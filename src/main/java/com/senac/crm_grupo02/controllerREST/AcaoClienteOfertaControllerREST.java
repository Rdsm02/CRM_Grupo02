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
import com.senac.crm_grupo02.domain.AcaoClienteOferta;
import com.senac.crm_grupo02.service.AcaoClienteOfertaService;
import com.senac.crm_grupo02.service.AcaoService;
import com.senac.crm_grupo02.service.ClienteService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/acaoClienteOfertaREST")
public class AcaoClienteOfertaControllerREST {
	
	@Autowired
	AcaoClienteOfertaService servicoAcaoClienteOferta;
	
	@Autowired
	ClienteService servicoCliente;
	
	@Autowired
	AcaoService servicoAcao;
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/cadastrarAcaoClienteOferta", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public AcaoClienteOferta cadastrarAcaoClienteOferta(@RequestBody AcaoClienteOferta acaoClienteOferta) throws ObjectNotFoundException{
		
		AcaoClienteOferta acaoClienteOfertaNovo = new AcaoClienteOferta();
		acaoClienteOfertaNovo.setAcaoId(acaoClienteOferta.getAcaoId());
		acaoClienteOfertaNovo.setDescricao(acaoClienteOferta.getDescricao());
		acaoClienteOfertaNovo.setData(acaoClienteOferta.getData());
		acaoClienteOfertaNovo.setHora(acaoClienteOferta.getHora());
		
		acaoClienteOfertaNovo.setAcaoId(servicoAcao.search(acaoClienteOferta.getAcaoId().getId()));
		
		acaoClienteOfertaNovo.setClienteId(servicoCliente.procurarPorCPFCliente(acaoClienteOferta.getClienteId().getCpf()));
		
		servicoAcaoClienteOferta.save(acaoClienteOfertaNovo);
		
        return acaoClienteOfertaNovo;
    }

}
