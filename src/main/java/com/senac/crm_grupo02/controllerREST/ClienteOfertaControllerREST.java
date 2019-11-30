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

import com.senac.crm_grupo02.domain.CategoriasClienteRetornoConsultaNativeQuery;
import com.senac.crm_grupo02.domain.Cliente;
import com.senac.crm_grupo02.domain.ClienteOferta;
import com.senac.crm_grupo02.domain.ClienteOfertaRetornoConsultaNativeQuery;
import com.senac.crm_grupo02.domain.EtapaFunil;
import com.senac.crm_grupo02.domain.Oferta;
import com.senac.crm_grupo02.domain.Produto;
import com.senac.crm_grupo02.service.ClienteOfertaService;
import com.senac.crm_grupo02.service.ClienteService;
import com.senac.crm_grupo02.service.EtapaFunilService;
import com.senac.crm_grupo02.service.OfertaService;
import com.senac.crm_grupo02.service.ProdutoService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/clienteClienteOfertaREST")
public class ClienteOfertaControllerREST {
	
	@Autowired
	ClienteOfertaService servicoClienteOferta;

	@Autowired
	ClienteService servicoCliente;
	
	@Autowired
	OfertaService servicoOferta;
	
	@Autowired
	EtapaFunilService servicoEtapaFunil;
	
	@Autowired
	ProdutoService servicoProduto;
	
	@ResponseStatus(HttpStatus.OK)
    @RequestMapping(value ="/cadastrarClienteOferta", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void cadastrarClienteOferta(@RequestBody ClienteOferta clienteOferta) throws ObjectNotFoundException{

		Integer c1 = clienteOferta.getClienteId().getId().intValue();
		Integer o1 = clienteOferta.getOfertaId().getId();
		Produto p1 = servicoProduto.search(o1);
		Integer p2 = p1.getId();
		Integer e1 = clienteOferta.getFunilEtapa().getId();

		servicoClienteOferta.atribuirClienteOferta(o1, p2, c1, e1);

    }
	
	@RequestMapping(value = "/buscarClienteOfertaPorOfertaId", method = RequestMethod.GET)
	public void buscarClienteOfertaPorOfertaId(@RequestParam("ofertaId") int ofertaId) throws ObjectNotFoundException {
		//CategoriasClienteRetornoConsultaNativeQuery ccrcnq = new CategoriasClienteRetornoConsultaNativeQuery();
		List<List<Object>> listaClienteOferta = new ArrayList<List<Object>>();
		listaClienteOferta = servicoClienteOferta.buscarClienteOfertaPorOfertaId(ofertaId);	
		
		Map<Integer, ClienteOferta> clienteOfertahas = new HashMap<Integer, ClienteOferta>();
		
		int cont = 1;
		
		for (List<Object> listaClienteOfertaItem: listaClienteOferta) {	
			ClienteOfertaRetornoConsultaNativeQuery corcnq = new ClienteOfertaRetornoConsultaNativeQuery();
			/*corcnq.setClienteId(listaClienteOfertaItem.get(5));
			ccrcnq.setCliente_dado_tipo_categoria_id(Integer.parseInt(ClienteCategoriaLista.get(0).toString()));
			ccrcnq.setCliente_dado_tipo_categoria_descricao(ClienteCategoriaLista.get(1).toString());
			ccrcnq.setCliente_dado_tipo_id(Integer.parseInt(ClienteCategoriaLista.get(2).toString()));
			ccrcnq.setCliente_dado_tipo_descricao(ClienteCategoriaLista.get(3).toString());
			ccrcnq.setCliente_dado_tipo_mascara(ClienteCategoriaLista.get(4).toString());
			ccrcnq.setCliente_dado_id(Integer.parseInt(ClienteCategoriaLista.get(5).toString()));
			ccrcnq.setCliente_dado_descricao(ClienteCategoriaLista.get(6).toString());
			
			clienteCategoriahas.put(cont, ccrcnq);	
			cont++;							
		}	
		
		return new ResponseEntity<List<Object>>(new ArrayList<Object>(clienteCategoriahas.values()), HttpStatus.OK);		*/
	}
	
	
	}
}
