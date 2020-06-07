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
	
	public List<Bandeirinha> all(){
		TypedQuery<Bandeirinha> query = this.em.createQuery("from Bandeirinha", Bandeirinha.class);
		for (Bandeirinha b : query.getResultList()) {
			b.getNome();
		}
		return query.getResultList();
	}
	
	public void salvarBandeirinha( Bandeirinha bandeirinha) {
		EntityTransaction et = this.em.getTransaction();
		
		et.begin();
		this.em.merge(bandeirinha);
		et.commit();
	}
	

}
