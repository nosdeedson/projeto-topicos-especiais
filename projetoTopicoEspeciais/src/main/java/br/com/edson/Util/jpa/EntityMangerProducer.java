package br.com.edson.Util.jpa;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityMangerProducer {
	
	
	private EntityManagerFactory emf;

	public EntityMangerProducer(EntityManagerFactory emf) {
		this.emf = Persistence.createEntityManagerFactory("projeto_tpPU");
	}

	@Produces
	@javax.enterprise.context.RequestScoped
	public EntityManager createEntityManager() {
			return emf.createEntityManager();
	}
	
	public void closeEntityManager( @Disposes EntityManager em) {
		em.close();
	}

}
