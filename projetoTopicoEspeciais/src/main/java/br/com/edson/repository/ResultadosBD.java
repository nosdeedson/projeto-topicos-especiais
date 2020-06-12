package br.com.edson.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.edson.Model.Resultado;

public class ResultadosBD implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	@Inject
	public ResultadosBD(EntityManager em) {
		this.em = em;
	}
	
	public void salvarResultado(Resultado resultado) {
		this.em.merge(resultado);
	}
	
}
