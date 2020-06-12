package br.com.edson.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import br.com.edson.Model.Jogador;

public class JogadoresBD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	@Inject
	public JogadoresBD(EntityManager em) {
		this.em = em;
	}
	
	public void excluirJogador( Jogador jogador) {
		em.remove(jogador);
	}
	
	public Jogador porId(Long id) {
		return em.find(Jogador.class, id);
	}
	
	public void salvarJogador(Jogador jogador) {
		em.merge(jogador);
	}
	
	public List<Jogador> todos(){
		TypedQuery<Jogador> query = em.createQuery("from Jogador", Jogador.class);
		return query.getResultList();		
	}
	
	

}
