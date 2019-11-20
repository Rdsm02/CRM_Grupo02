package com.senac.crm_grupo02.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.Role;
import com.senac.crm_grupo02.repository.RoleRepository;


@Service
public class RoleService {
	

	@Autowired
	RoleRepository repo;
	
	
	public Role save(Role role) {
		return repo.save(role);
	}

}
