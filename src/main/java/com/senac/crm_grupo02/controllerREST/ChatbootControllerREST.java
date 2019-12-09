package com.senac.crm_grupo02.controllerREST;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping("/chatbootREST")
public class ChatbootControllerREST {
	
	@RequestMapping(value = "/enviarTextoAoServidor", method = RequestMethod.GET)
	public String enviarTextoAoServidor(@RequestParam("texto") String texto) throws ObjectNotFoundException {
		
		if(texto.equals("Ola")) {
			return "Bem vindo ao Senac! Eu sou a SEIA(Senac inteligência Artificial)  Por favor digite seu nome completo!!!";
		}else if(texto.equals("help")) {
			return "Precisamos do seu nome para comerçamos a nos falar";
		}
		
		return "Não Consegui entender o que você disse, por favor digite seu nome completo!!!";		
	}

}
