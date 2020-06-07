package br.com.edson.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.edson.Model.Juiz;

public class JuizesBD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	@Inject
	public JuizesBD(EntityManager em) {
		this.em = em;
	}
	
	public void salvaJuiz( Juiz juiz) {
		EntityTransaction et = this.em.getTransaction();
		
		et.begin();
		this.em.merge(juiz);
		et.commit();
	}
	
	

}
