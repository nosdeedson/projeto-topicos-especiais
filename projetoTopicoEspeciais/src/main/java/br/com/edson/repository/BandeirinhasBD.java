package br.com.edson.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.edson.Model.Bandeirinha;

public class BandeirinhasBD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	@Inject
	public BandeirinhasBD(EntityManager em) {
		this.em = em;
	}
	
	public Bandeirinha porId(Long id){
		return em.find(Bandeirinha.class, id);		
	}
	
	public void salvarBandeirinha( Bandeirinha bandeirinha) {
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.merge(bandeirinha);
		et.commit();
	}
	
	public List<Bandeirinha> todos(){
		TypedQuery<Bandeirinha> query = em.createQuery("from Bandeirinha", Bandeirinha.class);
		return query.getResultList();
	}
	
	
}
