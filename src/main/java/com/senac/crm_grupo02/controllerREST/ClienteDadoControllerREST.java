package com.senac.crm_grupo02.controllerREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.senac.crm_grupo02.domain.ClienteDadoTipo;
import com.senac.crm_grupo02.domain.ClienteDadoTipoCategoria;
import com.senac.crm_grupo02.service.ClienteDadoTipoCategoriaService;
import com.senac.crm_grupo02.service.ClienteDadoTipoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/dadoREST")
public class ClienteDadoControllerREST {
	
	@Autowired
	ClienteDadoTipoService servicoDadoCliente;
	
	@Autowired
	ClienteDadoTipoCategoriaService servicoCategoriaCliente;
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/cadastrarClienteDado", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDadoTipo cadastrarCliente(@RequestBody ClienteDadoTipo dadoCliente) throws ObjectNotFoundException{
		
		ClienteDadoTipo cdt = new ClienteDadoTipo();
		cdt.setCodigo(dadoCliente.getCodigo());
		cdt.setDescricao(dadoCliente.getDescricao());
		cdt.setStatus(dadoCliente.getStatus());
		cdt.setObrigatorio(dadoCliente.getObrigatorio());
		cdt.setPadrao(dadoCliente.getPadrao());
		cdt.setMascara(dadoCliente.getMascara());
		
		cdt.setCliente_dado_tipo_categoria(servicoCategoriaCliente.search(dadoCliente.getCliente_dado_tipo_categoria().getCodigo()));
		

		servicoDadoCliente.save(cdt);
		
        return cdt;
    }
}