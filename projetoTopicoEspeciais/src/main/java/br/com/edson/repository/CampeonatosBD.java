package br.com.edson.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.edson.Model.Campeonato;

public class CampeonatosBD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	@Inject
	public CampeonatosBD(EntityManager em) {
		this.em = em;
	}
	
	public Campeonato porId( Long id) {
		return em.find(Campeonato.class, id);
	}
	
	public void salvar(Campeonato campeonato) {
		EntityTransaction et = em.getTransaction();
		
		et.begin();		
		em.merge(campeonato);
		et.commit();
	}
	
	public List<Campeonato> todos(){
		TypedQuery<Campeonato> query = this.em.createQuery("from Campeonato", Campeonato.class);
		return query.getResultList();
	}
	

}
