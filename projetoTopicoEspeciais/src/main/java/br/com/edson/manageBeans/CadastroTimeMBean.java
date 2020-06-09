package br.com.edson.manageBeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.edson.Model.Bandeirinha;
import br.com.edson.Model.Time;
import br.com.edson.repository.TimesBD;

@Named
@javax.faces.view.ViewScoped
public class CadastroTimeMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Time time;
	
	@Inject
	private TimesBD timesBD;

	public void salvar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			timesBD.salvarTime(time);
			time = new Time();
			context.addMessage(null, new FacesMessage("Time salvo com sucesso!!!"));
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		}
		
	}
	
	
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	
	

}
