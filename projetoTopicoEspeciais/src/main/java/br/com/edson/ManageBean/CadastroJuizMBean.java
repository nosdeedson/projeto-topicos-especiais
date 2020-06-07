package br.com.edson.ManageBean;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.edson.Model.Juiz;
import br.com.edson.repository.JuizesBD;

@Named
@javax.faces.view.ViewScoped
public class CadastroJuizMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Juiz juiz;
	
	@Inject
	private JuizesBD juizes;

	public Juiz getJuiz() {
		return juiz;
	}
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			juizes.salvaJuiz(juiz);
			juiz = new Juiz();
			context.addMessage(null, new FacesMessage("Juiz salvo com sucesso!!!"));
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
	}

	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}

	public JuizesBD getJuizes() {
		return juizes;
	}

	public void setJuizes(JuizesBD juizes) {
		this.juizes = juizes;
	}
	
	

}
