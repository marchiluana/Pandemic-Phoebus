package com.pandemic.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pandemic.apirest.models.RecursosConfiguracao;

public interface RecursosConfiguracaoRepository extends JpaRepository<RecursosConfiguracao, Long>{
	
	@Query("select R from RecursosConfiguracao R where R.nome = ?1")
	RecursosConfiguracao findByNome(String nome);

}
