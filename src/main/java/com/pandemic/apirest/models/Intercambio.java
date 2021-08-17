package com.pandemic.apirest.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_INTERCAMBIO")
public class Intercambio implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne(cascade = CascadeType.ALL)
	private Hospital hospitalOrigem;

	@ManyToOne(cascade = CascadeType.ALL)
	private Hospital hospitalDestino;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "recursos_trocados_origem_id", referencedColumnName = "id")
	private RecursosTrocados recursosTrocadosOrigem;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "recursos_trocados_destino_id", referencedColumnName = "id")
	private RecursosTrocados recursosTrocadosDestino;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Hospital getHospitalOrigem() {
		return hospitalOrigem;
	}

	public void setHospitalOrigem(Hospital hospitalOrigem) {
		this.hospitalOrigem = hospitalOrigem;
	}

	public Hospital getHospitalDestino() {
		return hospitalDestino;
	}

	public void setHospitalDestino(Hospital hospitalDestino) {
		this.hospitalDestino = hospitalDestino;
	}

	public RecursosTrocados getRecursosTrocadosOrigem() {
		return recursosTrocadosOrigem;
	}

	public void setRecursosTrocadosOrigem(RecursosTrocados recursosTrocadosOrigem) {
		this.recursosTrocadosOrigem = recursosTrocadosOrigem;
	}

	public RecursosTrocados getRecursosTrocadosDestino() {
		return recursosTrocadosDestino;
	}

	public void setRecursosTrocadosDestino(RecursosTrocados recursosTrocadosDestino) {
		this.recursosTrocadosDestino = recursosTrocadosDestino;
	}

}
