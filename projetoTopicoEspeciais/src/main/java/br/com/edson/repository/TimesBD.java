package br.com.edson.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.edson.Model.Time;

public class TimesBD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	@Inject
	public TimesBD(EntityManager em) {
		this.em = em;
	}
	
	public Time porId(Long id) {
		 return this.em.find(Time.class, id);
	}
	
	public void salvarTime(Time time) {
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(time);
		et.commit();
	}
	
	public List<Time> todos(){
		TypedQuery<Time> query = this.em.createQuery("from Time", Time.class);
		
		return query.getResultList();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
