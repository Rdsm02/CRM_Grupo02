package com.senac.crm_grupo02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("dashboard")
public class DashBoardController {
	
	@GetMapping("/dashboard")
	public ModelAndView paginaPrincipal() {
		ModelAndView mv = new ModelAndView("paginas/dashboard/dashboardRelatorios");
		//mv.addObject("clientes", servicoCliente.searchAll());
		return mv;
	}

}
