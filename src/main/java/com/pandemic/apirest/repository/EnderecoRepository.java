package com.pandemic.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pandemic.apirest.models.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}