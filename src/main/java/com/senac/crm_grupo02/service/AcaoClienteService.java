package com.senac.crm_grupo02.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.crm_grupo02.domain.Acao;
import com.senac.crm_grupo02.domain.AcaoCliente;
import com.senac.crm_grupo02.domain.Dashboard;
import com.senac.crm_grupo02.repository.AcaoClienteRepository;
import com.senac.crm_grupo02.repository.AcaoRepository;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AcaoClienteService {
	
	@Autowired
	AcaoClienteRepository repoAcaoCliente;
	
	@Autowired
	AcaoRepository repoAcao;
	
	@Autowired
	ClienteService servicoCliente;
	
	@SuppressWarnings("unused")
	public Dashboard buscarQuantidadeDeAcoesAtribuidasParaOClientePorAcaoId() {
		List<Acao> listaDeAcoes = new ArrayList<>();
		listaDeAcoes = repoAcao.findAll();
		List<Dashboard> listaDeDashboardQuantidadeAcao = new ArrayList<>();
		int somaQuantidadeDeAcoes = 0;
		for (Acao acao : listaDeAcoes) {
			Dashboard d = new Dashboard();
			d.setIdAcao(acao.getId());
			d.setDescricaoAcao(acao.getDescricao());
			List<List<Object>> listaAcoesRetornadasQueryNativa = new ArrayList<List<Object>>();			
			listaAcoesRetornadasQueryNativa = repoAcaoCliente.buscarQuantidadeDeAcoesAtribuidasParaOClientePorAcaoId(acao.getId());
			
			for (List<Object> quantidadeAcoesItem : listaAcoesRetornadasQueryNativa) {
				d.setQuantidadeDeAcao(Integer.parseInt(quantidadeAcoesItem.get(1).toString()));
				somaQuantidadeDeAcoes += Integer.parseInt(quantidadeAcoesItem.get(1).toString());
			}
			listaDeDashboardQuantidadeAcao.add(d);
		}
		
		
		/*=====[Cálculo da maior porcentagem de acoes registradas no cliente]=====*/
		
		int quantitadeTotalDeAcoes = somaQuantidadeDeAcoes;
		Dashboard dashboardComMaiorAcao = null;
		int valorMaiorQuantidadeIteracaoAcao = 0;
		
		//Verificar o maior valor dentre todas as acoes existentes
		for (Dashboard dashboard : listaDeDashboardQuantidadeAcao) {
			if(dashboard.getQuantidadeDeAcao() > valorMaiorQuantidadeIteracaoAcao) {
				valorMaiorQuantidadeIteracaoAcao = dashboard.getQuantidadeDeAcao();
				dashboardComMaiorAcao = dashboard;
			}			
		}
		
		
		BigDecimal porcentagemDaAcaoQueMaisAparece = (new BigDecimal(valorMaiorQuantidadeIteracaoAcao).multiply(new BigDecimal(100)).divide(new BigDecimal(quantitadeTotalDeAcoes), 1, RoundingMode.HALF_UP));
		dashboardComMaiorAcao.setPercentual(porcentagemDaAcaoQueMaisAparece);
		
		return dashboardComMaiorAcao;
	}
	
	public List<AcaoCliente>listarHistoricoCliente(Integer idCliente) throws ObjectNotFoundException {
		
		return repoAcaoCliente.findByClienteId(servicoCliente.search(idCliente));
		
	}
	
	public AcaoCliente search(Integer id) throws ObjectNotFoundException{
		Optional<AcaoCliente> acaoCliente = repoAcaoCliente.findById(id);
		return acaoCliente.orElseThrow(() -> new ObjectNotFoundException(
				"não encontrado. id: " + id + ", Tipo!" + AcaoCliente.class.getName()));		
	}
	

	public AcaoCliente save(AcaoCliente acaoCliente) {
		acaoCliente.setId(null);
		return repoAcaoCliente.save(acaoCliente);
	}
	
	public List<AcaoCliente> searchAll(){
		return repoAcaoCliente.findAll();
	}
	
	
	public List<AcaoCliente> saveAll(List<AcaoCliente> acaoClientes){
		return repoAcaoCliente.saveAll(acaoClientes);
	}
	
	
	public void delete(Integer id) {
		repoAcaoCliente.deleteById(id);
	}
	
}
