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

import br.com.edson.Model.Time;
import br.com.edson.repository.TimesBD;

@Named
@javax.faces.view.ViewScoped
public class ConsultaTimeMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private List<Time> times = new ArrayList<Time>();
	
	@Inject
	private TimesBD timesBD;
	
	@Inject
	private Time timeSerExcluido;
	
	@Inject
	private EntityManager em;
	// métodos
	public void buscaTimes() {
		times = timesBD.todos();
	}
	
	public void excluir() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			
			timesBD.excluirTime(timeSerExcluido);
			context.addMessage(null, new FacesMessage("Time excluído com sucesso!!!"));
			et.commit();
			this.buscaTimes();

		} catch (Exception e) {
			et.rollback();
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
	}
	
	// getters setters
	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}

	public Time getTimeSerExcluido() {
		return timeSerExcluido;
	}

	public void setTimeSerExcluido(Time timeSerExcluido) {
		this.timeSerExcluido = timeSerExcluido;
	}
	
	
	

}
