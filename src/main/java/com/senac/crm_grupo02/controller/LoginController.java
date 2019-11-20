package com.senac.crm_grupo02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.senac.crm_grupo02.security.CurrentUserDetailsService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	CurrentUserDetailsService servicoSecurity;
	
	@GetMapping("/autenticacao")
	public ModelAndView autenticacao() {
		ModelAndView mv = new ModelAndView("paginas/login/login");
		//mv.addObject("usuario", servicoCliente.searchAll());
		return mv;
	}
	
	@GetMapping("/autenticacao/{login}")
	public ModelAndView autenticacaoPorId(@PathVariable("login") String loginUsuario) {
		servicoSecurity.loadUserByUsername(loginUsuario);
		ModelAndView mv = new ModelAndView("paginas/login/login");
		//mv.addObject("usuario", servicoCliente.searchAll());
		return mv;
	}
	
}
