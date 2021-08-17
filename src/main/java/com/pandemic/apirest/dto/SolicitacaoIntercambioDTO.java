package com.pandemic.apirest.dto;

import com.pandemic.apirest.models.RecursosTrocados;

public class SolicitacaoIntercambioDTO {

	private RecursosTrocados recursosTrocadosOrigem;
	private RecursosTrocados recursosTrocadosDestino;

	private long hospitalOrigemId;
	private long hospitalDestinoId;

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

	public long getHospitalOrigemId() {
		return hospitalOrigemId;
	}

	public void setHospitalOrigemId(long hospitalOrigemId) {
		this.hospitalOrigemId = hospitalOrigemId;
	}

	public long getHospitalDestinoId() {
		return hospitalDestinoId;
	}

	public void setHospitalDestinoId(long hospitalDestinoId) {
		this.hospitalDestinoId = hospitalDestinoId;
	}

}
