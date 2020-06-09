package br.com.edson.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.edson.Model.Campeonato;

public class CampeonatosBD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	@Inject
	public CampeonatosBD(EntityManager em) {
		this.em = em;
	}
	
	public Campeonato porid( Long id) {
		return em.find(Campeonato.class, id);
	}
	
	public void salvar(Campeonato campeonato) {
		EntityTransaction et = em.getTransaction();
		
		et.begin();		
		em.merge(campeonato);
		et.commit();
	}
	
	

}
