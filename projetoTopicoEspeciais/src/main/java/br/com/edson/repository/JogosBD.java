package br.com.edson.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.edson.Model.Jogo;

public class JogosBD implements Serializable {
	
	@Inject
	private EntityManager em;
	
	public void salvarJogo(Jogo jogo) {
		EntityTransaction et = em.getTransaction();
				
		et.begin();
		this.em.merge(jogo);
		et.commit();
	}

}
