package br.com.edson.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import br.com.edson.Model.Resultado;

public class ResultadosBD implements Serializable {

	private static final long serialVersionUID = 1L;

	private EntityManager em;

	@Inject
	public ResultadosBD(EntityManager em) {
		this.em = em;
	}
	
	public Long salvarResultado(Resultado resultado) {
		this.em.merge(resultado);
		
		String sql = "select max(idResultado) from Resultado";
		
		Long query = this.em.createQuery(sql, Long.class).getSingleResult();
		System.out.println(query);
		return query;
	}

	public Resultado porId(Long id) {
		return this.em.find(Resultado.class, id);
	}
	
}
