package com.pandemic.apirest.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.pandemic.apirest.dto.SolicitacaoIntercambioDTO;
import com.pandemic.apirest.models.Hospital;
import com.pandemic.apirest.models.Intercambio;
import com.pandemic.apirest.models.RecursosTrocados;
import com.pandemic.apirest.repository.HospitalRepository;
import com.pandemic.apirest.repository.IntercambioRepository;
import com.pandemic.apirest.repository.RecursosConfiguracaoRepository;
import com.pandemic.apirest.repository.RecursosTrocadosRepository;

@RestController
@RequestMapping(value = "/api")
public class IntercambioResource {

	@Autowired
	HospitalRepository hospitalRepository;

	@Autowired
	IntercambioRepository intercambioRepository;
	
	@Autowired
	RecursosTrocadosRepository recursosTrocadosRepository;
	
	@Autowired
	RecursosConfiguracaoRepository recursosConfiguracaoRepository;

	@PostMapping("/trocar")
	public void trocarRecursos(@RequestBody SolicitacaoIntercambioDTO solicitacao) {
		
		Intercambio intercambio = new Intercambio();

		Optional<Hospital> hospitalOrigem = hospitalRepository.findById(solicitacao.getHospitalOrigemId());
		Optional<Hospital> hospitalDestino = hospitalRepository.findById(solicitacao.getHospitalDestinoId());

		if ((hospitalDestino.isEmpty()) || (hospitalOrigem.isEmpty())) {

			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Hospital Origem ou Destino não encontrado!");
		}
		
		if(((solicitacao.getHospitalOrigemId()) == solicitacao.getHospitalDestinoId()))
		{
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hospital Origem e de Destino não podem ser iguais!");
		}
	
		RecursosTrocados recursosTrocadosOrigem = solicitacao.getRecursosTrocadosOrigem();
		RecursosTrocados recursosTrocadosDestino = solicitacao.getRecursosTrocadosDestino();
		
		if((calculaPontos(recursosTrocadosOrigem) > calculaPontos(recursosTrocadosDestino)) || (calculaPontos(recursosTrocadosOrigem) < calculaPontos(recursosTrocadosDestino)))
		{
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pontos de intercâmbio não sao iguais!");
		}
			intercambio.setHospitalOrigem(hospitalOrigem.get());
			intercambio.setHospitalDestino(hospitalDestino.get());
			
			intercambio.setRecursosTrocadosOrigem(recursosTrocadosOrigem);
			intercambio.setRecursosTrocadosDestino(recursosTrocadosDestino); 
			
			intercambioRepository.save(intercambio);  
	}
	
	public long calculaPontos(RecursosTrocados recurso) {
		
		long soma = 0;
		
		soma =+ recurso.getnAmbulancia() * recursosConfiguracaoRepository.findByNome("nAmbulancia").getPontos();
		soma =+ recurso.getnEnfermeiros() * recursosConfiguracaoRepository.findByNome("nEnfermeiros").getPontos();
		soma =+ recurso.getnMedicos() * recursosConfiguracaoRepository.findByNome("nMedico").getPontos();
		soma =+ recurso.getnRespirador() * recursosConfiguracaoRepository.findByNome("nRespirador").getPontos();
		soma =+ recurso.getnTomografo() * recursosConfiguracaoRepository.findByNome("nTomografo").getPontos();
		
		return soma;	
	}

}
