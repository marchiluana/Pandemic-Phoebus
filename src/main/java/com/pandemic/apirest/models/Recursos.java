package com.pandemic.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "TB_RECURSOS")
@Inheritance(strategy = InheritanceType.JOINED)
public class Recursos implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	long nMedicos;
	long nEnfermeiros;
	long nRespirador;
	long nTomografo;
	long nAmbulancia;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getnMedicos() {
		return nMedicos;
	}

	public void setnMedicos(long nMedicos) {
		this.nMedicos = nMedicos;
	}

	public long getnEnfermeiros() {
		return nEnfermeiros;
	}

	public void setnEnfermeiros(long nEnfermeiros) {
		this.nEnfermeiros = nEnfermeiros;
	}

	public long getnRespirador() {
		return nRespirador;
	}

	public void setnRespirador(long nRespirador) {
		this.nRespirador = nRespirador;
	}

	public long getnTomografo() {
		return nTomografo;
	}

	public void setnTomografo(long nTomografo) {
		this.nTomografo = nTomografo;
	}

	public long getnAmbulancia() {
		return nAmbulancia;
	}

	public void setnAmbulancia(long nAmbulancia) {
		this.nAmbulancia = nAmbulancia;
	}
	
}