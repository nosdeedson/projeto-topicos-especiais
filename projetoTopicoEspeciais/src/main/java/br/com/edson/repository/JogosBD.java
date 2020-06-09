package br.com.edson.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.edson.Model.Jogo;

public class JogosBD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	@Inject
	public JogosBD(EntityManager em) {
		this.em = em;
	}
	
	
	public void salvarJogo( Jogo jogo) {
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(jogo);
		et.commit();
	}
	
	

}
