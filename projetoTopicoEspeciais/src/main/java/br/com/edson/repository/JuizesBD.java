package br.com.edson.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.edson.Model.Juiz;

public class JuizesBD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private EntityManager em;

	@Inject
	public JuizesBD(EntityManager em) {
		this.em = em;
	}
	
	public Juiz porId(Long id) {
		return em.find(Juiz.class, id);
	}
	
	public void salvarJuiz( Juiz juiz) {
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(juiz);
		et.commit();
	}
	
	public List<Juiz> todos(){
		TypedQuery<Juiz> query = em.createQuery("from Juiz",Juiz.class);
		return query.getResultList();
	}

}
