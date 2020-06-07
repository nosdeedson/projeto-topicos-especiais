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
	
	public Time byId(Long id) {
		return this.em.find(Time.class, id);
	}
	
	/**
	 * busca todos os times
	 * @return
	 */
	public List<Time> all(){
		TypedQuery<Time> query = this.em.createQuery("from Time", Time.class);  
		return query.getResultList();
	}
	
	public void salvarTimes(Time time) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		this.em.merge(time);
		et.commit();
	}
	
	
	
	

}
