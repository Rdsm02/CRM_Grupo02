package com.senac.crm_grupo02.controllerREST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.senac.crm_grupo02.domain.Dashboard;
import com.senac.crm_grupo02.service.AcaoClienteService;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/dashboardREST")
public class DashboardControllerREST {
	
	@Autowired
	AcaoClienteService serivcoAcaoCliente;
	
	@RequestMapping(value = "/buscarQuantidadeDeAcoesAtribuidasParaOClientePorAcaoId", method = RequestMethod.GET)
	public ResponseEntity<List<Dashboard>> buscarQuantidadeDeAcoesAtribuidasParaOClientePorAcaoId() throws ObjectNotFoundException {
		
		Dashboard grafico;
		grafico = serivcoAcaoCliente.buscarQuantidadeDeAcoesAtribuidasParaOClientePorAcaoId();
		
		Map<Integer, Dashboard> acaohas = new HashMap<Integer, Dashboard>();
		
		acaohas.put(1, grafico);
		
		return new ResponseEntity<List<Dashboard>>(new ArrayList<Dashboard>(acaohas.values()), HttpStatus.OK);
	}

}
