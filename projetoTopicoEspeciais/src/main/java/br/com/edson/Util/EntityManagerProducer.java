package br.com.edson.Util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.omnifaces.cdi.ViewScoped;

@ApplicationScoped
public class EntityManagerProducer {
	
	private EntityManagerFactory emf;

	public EntityManagerProducer() {
		this.emf = Persistence.createEntityManagerFactory("projeto_tpPU");
	}
	
	@Produces
	@ViewScoped
	public EntityManager createEntityManger() {
		return emf.createEntityManager();
	}
	
	public void closeEntityManger( @Disposes EntityManager em) {
		em.close();
	}

}
