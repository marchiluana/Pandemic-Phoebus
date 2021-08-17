package com.pandemic.apirest.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_RECURSOS_TROCADOS")
public class RecursosTrocados extends Recursos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@OneToOne(mappedBy = "recursosTrocadosOrigem")
	Intercambio intercambioOrigem;
	
	@OneToOne(mappedBy = "recursosTrocadosDestino")
	Intercambio intercambioDestino;

}
