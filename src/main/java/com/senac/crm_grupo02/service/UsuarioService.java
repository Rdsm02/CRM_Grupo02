package com.senac.crm_grupo02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.Usuario;
import com.senac.crm_grupo02.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository repo;
	
	
	public Usuario save(Usuario usuario) {
		return repo.save(usuario);
	}
}
