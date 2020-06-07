package br.com.edson.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.edson.Model.Jogador;

public class JogadoresBD implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	@Inject
	public JogadoresBD(EntityManager em) {
		this.em = em;
	}

	public void salvarJogadores(Jogador jogador) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		this.em.merge(jogador);
		et.commit();
	}
	
	
	
	

}
