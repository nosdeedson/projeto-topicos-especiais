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

import br.com.edson.Model.Bandeirinha;
import br.com.edson.repository.BandeirinhasBD;

@Named
@javax.faces.view.ViewScoped
public class ConsultaBandeirinhaMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Bandeirinha bandeirinha;

	@Inject
	private BandeirinhasBD bandeirinhasBD;

	private List<Bandeirinha> bandeirinhas = new ArrayList<Bandeirinha>();

	@Inject
	private Bandeirinha banderinhaSerExcluido;

	@Inject
	private EntityManager em;
	
	// metodos

	public void buscaBandeirinhas() {
		bandeirinhas = bandeirinhasBD.todos();
	}

	public void excluirB() {
		FacesContext context = FacesContext.getCurrentInstance();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			
			bandeirinhasBD.excluirBandeirinha(banderinhaSerExcluido);
			context.addMessage(null, new FacesMessage("Bandeirinha excluído com sucesso!!!"));
			et.commit();
			this.buscaBandeirinhas();

		} catch (Exception e) {
			et.rollback();
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
	}


	// getters and setters
	public Bandeirinha getBandeirinha() {
		return bandeirinha;
	}

	public void setBandeirinha(Bandeirinha bandeirinha) {
		this.bandeirinha = bandeirinha;
	}

	public List<Bandeirinha> getBandeirinhas() {
		return bandeirinhas;
	}

	public void setBandeirinhas(List<Bandeirinha> bandeirinhas) {
		this.bandeirinhas = bandeirinhas;
	}

	

	public Bandeirinha getBanderinhaSerExcluido() {
		return banderinhaSerExcluido;
	}

	public void setBanderinhaSerExcluido(Bandeirinha banderinhaSerExcluido) {
		this.banderinhaSerExcluido = banderinhaSerExcluido;
	}

}
