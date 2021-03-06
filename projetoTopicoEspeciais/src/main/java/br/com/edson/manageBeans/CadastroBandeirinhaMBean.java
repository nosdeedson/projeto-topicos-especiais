package br.com.edson.manageBeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;

import br.com.edson.Model.Bandeirinha;
import br.com.edson.Util.Transactional;
import br.com.edson.repository.BandeirinhasBD;

@Named
@javax.faces.view.ViewScoped
public class CadastroBandeirinhaMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Bandeirinha bandeirinha;
	
	@Inject
	private BandeirinhasBD bandeirinhasBD;
	
	@Inject
	private EntityManager em;
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		EntityTransaction et = em.getTransaction();
		try {			
			et.begin();
			bandeirinhasBD.salvarBandeirinha(bandeirinha);
			bandeirinha = new Bandeirinha();
			context.addMessage(null, new FacesMessage("Bandeirinha salvo com sucesso!!!"));
			et.commit();
		} catch (Exception e) {
			et.rollback();
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
		
	}

	public Bandeirinha getBandeirinha() {
		return bandeirinha;
	}

	public void setBandeirinha(Bandeirinha bandeirinha) {
		this.bandeirinha = bandeirinha;
	}
	
	

}
