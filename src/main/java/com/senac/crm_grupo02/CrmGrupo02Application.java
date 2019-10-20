package com.senac.crm_grupo02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CrmGrupo02Application extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(CrmGrupo02Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CrmGrupo02Application.class);
	}

}
