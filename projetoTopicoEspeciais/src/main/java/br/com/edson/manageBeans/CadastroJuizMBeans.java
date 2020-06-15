package br.com.edson.manageBeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.edson.Model.Bandeirinha;
import br.com.edson.Model.Juiz;
import br.com.edson.repository.JuizesBD;

@Named
@javax.faces.view.ViewScoped
public class CadastroJuizMBeans implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Juiz juiz;

	@Inject
	private JuizesBD juizesBD;

	@Inject
	private EntityManager em;
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		EntityTransaction et= em.getTransaction();
		try {
			et.begin();
			juizesBD.salvarJuiz(juiz);
			juiz = new Juiz();
			context.addMessage(null, new FacesMessage("Juiz salvo com sucesso!!!"));
			et.commit();
		} catch (Exception e) {
			et.rollback();
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
	}
	
	public Juiz getJuiz() {
		return juiz;
	}

	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}
	
	

}
