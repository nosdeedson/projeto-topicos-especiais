package br.com.edson.manageBeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

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
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			campeonatosBD.salvar(campeonato);
			campeonato = new Campeonato();
			context.addMessage(null, new FacesMessage("Campeonato salvo com sucesso!!!"));
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
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
