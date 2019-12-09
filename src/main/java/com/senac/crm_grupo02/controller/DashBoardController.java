package com.senac.crm_grupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.service.EtapaFunilService;

@Controller
@RequestMapping("dashboard")
public class DashBoardController {
	
	@Autowired
	EtapaFunilService servicoEtapaFunil;
	
	@GetMapping("/dashboard")
	public ModelAndView paginaPrincipal() {
		ModelAndView mv = new ModelAndView("paginas/dashboard/dashboardRelatorios");
		mv.addObject("ofertasPorEtapa", servicoEtapaFunil.searchAll());
		return mv;
	}

}
