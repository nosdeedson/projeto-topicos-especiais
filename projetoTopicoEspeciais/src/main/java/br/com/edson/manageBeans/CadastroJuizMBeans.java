package br.com.edson.manageBeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

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
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			juizesBD.salvarJuiz(juiz);
			juiz = new Juiz();
			context.addMessage(null, new FacesMessage("Juiz salvo com sucesso!!!"));
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		}
	}
	
	public Juiz getJuiz() {
		return juiz;
	}

	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}
	
	

}
