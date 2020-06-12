package br.com.edson.manageBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;

import org.hibernate.validator.constraints.Email;

import br.com.edson.Model.Bandeirinha;
import br.com.edson.Model.Juiz;
import br.com.edson.repository.BandeirinhasBD;
import br.com.edson.repository.JuizesBD;
import br.com.edson.service.FalhaSistemaException;

@Named
@javax.faces.view.ViewScoped
public class ConsultaJuizMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Juiz juiz;

	@Inject
	private JuizesBD juizesBD;

	private List<Juiz> juizes = new ArrayList<Juiz>();

	@Inject
	private Juiz juizSerExcluido;

	@Inject
	private EntityManager em;
	
	// metodos

	public void buscaJuizes() {
		juizes = juizesBD.todos();
	}

	public void excluirJ() {
		FacesContext context = FacesContext.getCurrentInstance();
	    EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			juizesBD.excluirJuiz(juizSerExcluido);
			context.addMessage(null, new FacesMessage("Juiz excluído com sucesso!!!"));
			et.commit();
			this.buscaJuizes();
		} catch (Exception e) {
			et.rollback();
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
		
	}

	// getters and setters

	public Juiz getJuiz() {
		return juiz;
	}

	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}

	public List<Juiz> getJuizes() {
		return juizes;
	}

	public void setJuizes(List<Juiz> juizes) {
		this.juizes = juizes;
	}

	public Juiz getJuizSerExcluido() {
		return juizSerExcluido;
	}

	public void setJuizSerExcluido(Juiz juizSerExcluido) {
		this.juizSerExcluido = juizSerExcluido;
	}

}
