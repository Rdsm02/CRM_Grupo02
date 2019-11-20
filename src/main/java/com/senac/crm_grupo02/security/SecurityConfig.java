package com.senac.crm_grupo02.security;


import org.springframework.core.annotation.Order;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
@Configuration
@Order
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private static String [] PUBLIC_MATCHERS = {"/h2-console/**","/menu", };
	private static String [] PUBLIC_MATCHERS_GET = {"/aluno/**", "/login/**"};
	private static String [] PAGINA_LOGIN_LOGOUT_ERRO = {"/login/**"};
	
	//TODO - apagar posteriormente!!!!!!!
	private static String [] SOLUCAO_CONTENCAO = {"/cliente/**","/produto/**","/clienteDadoTipoCategoria/**","/clienteDadotipo/**","/funil/**","/dashboard/**","/nivelInstrucao/**","/acao/**","/etapa/**","/oferta/**"};
	private static String [] SOLUCAO_CONTENCAO_REST = {"/acaoClienteREST/**","/acaoREST/**","/clienteREST/**","/dadoREST/**","/clienteDadoTipoCategoriaREST/**","/clienteDadoTipoREST/**","/etapaFunilREST/**","/nivelInstrucaoREST/**","/ofertaREST/**","/produtoREST/**"};
	
	
	@Autowired
	private CurrentUserDetailsService userDetailsService;
	
	protected void configure (HttpSecurity http) throws Exception{
		
		http.authorizeRequests()
		
		.antMatchers(PUBLIC_MATCHERS).permitAll()
		//.antMatchers(PUBLIC_MATCHERS).hasRole("ADMIN")
		
		.antMatchers(HttpMethod.GET,PUBLIC_MATCHERS_GET).permitAll()
		
		//.antMatchers("/curso/formInserirCurso").permitAll()
		//.antMatchers("/curso/formInserirCurso").hasRole("USER")
		
		
		.anyRequest().authenticated()
		.antMatchers(PAGINA_LOGIN_LOGOUT_ERRO).permitAll()
		
		
		//TODO - solucao de contencao - APAGAR POSTERIORMENTE - RODRIGO MOREIRA
		.antMatchers(SOLUCAO_CONTENCAO).permitAll()
		
		
		
		.and().formLogin().loginPage("/login/autenticacao").permitAll()
		.failureUrl("/index?error=true")
		.defaultSuccessUrl("/principal/index", true).permitAll()
     
		
		.and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		http.csrf().disable();
        http.headers().frameOptions().disable();
		

		
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/css/**", "/js/**","/img/**","/media/**","/vendors/**");
		
		//TODO - solucao de contecao apagar posteriormente!!!
		web.ignoring().antMatchers(SOLUCAO_CONTENCAO);
		web.ignoring().antMatchers(SOLUCAO_CONTENCAO_REST);
	}
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
}
