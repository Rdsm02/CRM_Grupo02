package com.senac.crm_grupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.service.ClienteDadoTipoCategoriaService;
import com.senac.crm_grupo02.service.ClienteDadoTipoService;

@Controller
@RequestMapping("clienteDadotipo")
public class ClienteDadoTipoController {
	
	@Autowired
	ClienteDadoTipoService servicoClienteDadoTipo;
	
	@Autowired
	ClienteDadoTipoCategoriaService servicoClienteDadoTipoCategoria;
	
	@GetMapping("/paginaDadoTipoCliente")
	public ModelAndView paginaDadoTipoCliente() {
		ModelAndView mv = new ModelAndView("paginas/parametrizacao/paginaDadoTipoCliente");
		mv.addObject("tipoDados", servicoClienteDadoTipo.searchAll());
		mv.addObject("CategoriaDadosLista", servicoClienteDadoTipoCategoria.searchAll());
		return mv;
	}

}
