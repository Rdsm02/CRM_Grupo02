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
import com.senac.crm_grupo02.service.ClienteDadoTipoCategoriaService;
import com.senac.crm_grupo02.service.ClienteDadoTipoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/clienteDadoTipoREST")
public class ClienteDadoTipoControllerREST {
	
	@Autowired
	ClienteDadoTipoService servicoClienteDadoTipo;
	
	@Autowired
	ClienteDadoTipoCategoriaService servicoClienteDadoTipoCategoria;
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/cadastrarProduto", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDadoTipo cadastrarCliente(@RequestBody ClienteDadoTipo clienteDadoTipo) throws ObjectNotFoundException{
		
		ClienteDadoTipo clienteDadoTipoNovo = new ClienteDadoTipo();
		clienteDadoTipoNovo.setCodigo(clienteDadoTipo.getCodigo());
		clienteDadoTipoNovo.setDescricao(clienteDadoTipo.getDescricao());
		clienteDadoTipoNovo.setStatus(clienteDadoTipo.getStatus());
		clienteDadoTipoNovo.setObrigatorio(clienteDadoTipo.getObrigatorio());
		clienteDadoTipoNovo.setPadrao(clienteDadoTipo.getPadrao());
		clienteDadoTipoNovo.setMascara(clienteDadoTipo.getMascara());
		
		clienteDadoTipoNovo.setCliente_dado_tipo_categoria(servicoClienteDadoTipoCategoria.search(clienteDadoTipo.getCliente_dado_tipo_categoria().getCodigo()));
	
		

		servicoClienteDadoTipo.save(clienteDadoTipoNovo);
		
        return clienteDadoTipoNovo;
    }

}
