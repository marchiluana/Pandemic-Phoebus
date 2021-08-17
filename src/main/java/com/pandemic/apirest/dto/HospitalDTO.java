package com.pandemic.apirest.dto;

import com.pandemic.apirest.models.Endereco;
import com.pandemic.apirest.models.Hospital;
import com.pandemic.apirest.models.Recursos;

public class HospitalDTO {

	private long id;

	private String nome;

	private String cnpj;

	private Endereco endereco;

	private float latitude;

	private float longitude;

	private Recursos recursos;

	private double percentagemOcupacao;

	public HospitalDTO(Hospital hospital) {
		super();
		this.id = hospital.getId();
		this.nome = hospital.getNome();
		this.cnpj = hospital.getCnpj();
		this.endereco = hospital.getEndereco();
		this.latitude = hospital.getLatitude();
		this.longitude = hospital.getLongitude();
		this.recursos = hospital.getRecursos();
		this.percentagemOcupacao = hospital.calculaPercentagem();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public Recursos getRecursos() {
		return recursos;
	}

	public void setRecursos(Recursos recursos) {
		this.recursos = recursos;
	}

	public double getPercentagemOcupacao() {
		return percentagemOcupacao;
	}

	public void setPercentagemOcupacao(float percentagemOcupacao) {
		this.percentagemOcupacao = percentagemOcupacao;
	}

}
