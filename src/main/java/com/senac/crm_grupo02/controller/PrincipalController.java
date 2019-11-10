package com.senac.crm_grupo02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("principal")
public class PrincipalController {
	
	@GetMapping("/index")
	public ModelAndView paginaPrincipal() {
		ModelAndView mv = new ModelAndView("paginas/principal/index");
		return mv;
	}

}
