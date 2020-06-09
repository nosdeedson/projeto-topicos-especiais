package br.com.edson.manageBeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.edson.Model.Bandeirinha;
import br.com.edson.repository.BandeirinhasBD;

@Named
@javax.faces.view.ViewScoped
public class CadastroBandeirinhaMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Bandeirinha bandeirinha;
	
	@Inject
	private BandeirinhasBD bandeirinhasBD;
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			bandeirinhasBD.salvarBandeirinha(bandeirinha);
			bandeirinha = new Bandeirinha();
			context.addMessage(null, new FacesMessage("Bandeirinha salvo com sucesso!!!"));
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		}
		
	}

	public Bandeirinha getBandeirinha() {
		return bandeirinha;
	}

	public void setBandeirinha(Bandeirinha bandeirinha) {
		this.bandeirinha = bandeirinha;
	}
	
	

}
