package com.senac.crm_grupo02.controllerREST;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.senac.crm_grupo02.domain.ClienteDadoTipoCategoria;
import com.senac.crm_grupo02.service.ClienteDadoTipoCategoriaService;


@RestController
@RequestMapping("/categoriaREST")
public class ClienteDadoTipoCategoriaREST {
	
	@Autowired
	ClienteDadoTipoCategoriaService servicoCategoriaCliente;
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/cadastrarCategoria", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ClienteDadoTipoCategoria cadastrarCliente(@RequestBody ClienteDadoTipoCategoria categoriaCliente){
		
		ClienteDadoTipoCategoria cdtc = new ClienteDadoTipoCategoria();
		cdtc.setCodigo(categoriaCliente.getCodigo());
		cdtc.setDescricao(categoriaCliente.getDescricao());
		cdtc.setStatus(categoriaCliente.getStatus());

		servicoCategoriaCliente.save(cdtc);
		
        return cdtc;
    }

}
