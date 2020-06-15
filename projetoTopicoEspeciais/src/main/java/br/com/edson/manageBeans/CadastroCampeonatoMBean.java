package br.com.edson.manageBeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.edson.Model.Bandeirinha;
import br.com.edson.Model.Campeonato;
import br.com.edson.Model.FormatoCampeonatoEnum;
import br.com.edson.repository.CampeonatosBD;

@Named
@javax.faces.view.ViewScoped
public class CadastroCampeonatoMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Campeonato campeonato;
	
	@Inject
	private CampeonatosBD campeonatosBD;
	
	@Inject
	private EntityManager em;
	
	public void salvar() {
		EntityTransaction et = em.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			et.begin();
			campeonatosBD.salvar(campeonato);
			campeonato = new Campeonato();
			context.addMessage(null, new FacesMessage("Campeonato salvo com sucesso!!!"));
			et.commit();
		} catch (Exception e) {
			et.rollback();
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
	}
	
	/**
	 * pega os enums
	 * @return
	 */
	public FormatoCampeonatoEnum[] getTipoCampeonato() {
		return FormatoCampeonatoEnum.values();
	}

}
