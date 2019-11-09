package com.senac.crm_grupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.service.ClienteDadoTipoCategoriaService;

@Controller
@RequestMapping("parametrizacao")
public class ClienteDadoTipoCategoriaController {
	
	@Autowired
	ClienteDadoTipoCategoriaService servicoClienteDadoTipoCategoria;
	
	@GetMapping("/listarCategorias")
	public ModelAndView paginaPrincipal() {
		ModelAndView mv = new ModelAndView("paginas/parametrizacao/categoriaDadoCliente");
		mv.addObject("categorias", servicoClienteDadoTipoCategoria.searchAll());
		return mv;
	}

}
