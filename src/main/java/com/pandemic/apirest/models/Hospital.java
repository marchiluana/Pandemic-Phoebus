package com.pandemic.apirest.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_HOSPITAL")
public class Hospital implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nome;

	private String cnpj;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;

	private float latitude;

	private float longitude;

	private long capacidadeTotal;
	private long capacidadeAtual;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "recursos_id", referencedColumnName = "id")
	private Recursos recursos;

	@OneToMany(targetEntity = Intercambio.class, mappedBy = "hospitalOrigem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Intercambio> intercambiosOrigem;

	@OneToMany(targetEntity = Intercambio.class, mappedBy = "hospitalDestino", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Intercambio> intercambiosDestino;

	public double calculaPercentagem() {

		double percentagem = ((float) capacidadeAtual / capacidadeTotal) * 100;

		BigDecimal pd = new BigDecimal(percentagem).setScale(1, RoundingMode.HALF_DOWN);

		return pd.doubleValue();
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

	public long getCapacidadeTotal() {
		return capacidadeTotal;
	}

	public void setCapacidadeTotal(long capacidadeTotal) {
		this.capacidadeTotal = capacidadeTotal;
	}

	public long getCapacidadeAtual() {
		return capacidadeAtual;
	}

	public void setCapacidadeAtual(long capacidadeAtual) {
		this.capacidadeAtual = capacidadeAtual;
	}

}
