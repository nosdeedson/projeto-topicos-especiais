package br.com.edson.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.edson.Model.Bandeirinha;

public class BandeirinhasBD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;
	
	@Inject
	public BandeirinhasBD(EntityManager em) {
		this.em = em;
	}
	
	
	public void excluirBandeirinha(Bandeirinha bandeirinha){
		em.remove(bandeirinha);
	}
	
	public Bandeirinha porId(Long id){
		return em.find(Bandeirinha.class, id);		
	}
	
	
	public void salvarBandeirinha( Bandeirinha bandeirinha) {
		em.merge(bandeirinha);
	}
	
	public List<Bandeirinha> todos(){
		TypedQuery<Bandeirinha> query = em.createQuery("from Bandeirinha", Bandeirinha.class);
		return query.getResultList();
	}
	
	
}
