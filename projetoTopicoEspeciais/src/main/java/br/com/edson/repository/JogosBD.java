package br.com.edson.repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import br.com.edson.Model.Jogo;

public class JogosBD implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private EntityManager em;

	@Inject
	public JogosBD(EntityManager em) {
		this.em = em;
	}
	
	public void salvarJogo( Jogo jogo) {
	
		em.merge(jogo);
		
	}

	public List<Jogo> todos(Long id) {
		
		String busca = "from Jogo";
		TypedQuery<Jogo> query = this.em.createQuery(busca, Jogo.class);
		List<Jogo> jogos = new ArrayList<Jogo>();
		for (Jogo jogo : query.getResultList()) {
			if(jogo.getCampeonato().getIdCampeonato() == id)
			jogos.add(jogo);
		}
		return jogos;
	}

	public Jogo porId(Long id) {
		return this.em.find(Jogo.class, id);
	}
	
	

}
