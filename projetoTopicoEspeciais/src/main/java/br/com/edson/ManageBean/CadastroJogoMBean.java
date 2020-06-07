package br.com.edson.ManageBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.edson.Model.Bandeirinha;
import br.com.edson.Model.Jogo;
import br.com.edson.Model.Juiz;
import br.com.edson.Model.Time;
import br.com.edson.repository.BandeirinhasBD;
import br.com.edson.repository.JogosBD;

@Named
@javax.faces.view.ViewScoped
public class CadastroJogoMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Jogo jogo;
	
	@Inject
	private Bandeirinha bandeirinha;
	
	private List<Bandeirinha> bandeirinhas = new ArrayList<Bandeirinha>();
	
	@Inject
	private BandeirinhasBD badeirinhaBanco;
	
	@Inject
	private Juiz juis;
	
	@Inject
	private Time mandante;
	
	@Inject
	private Time visitante;
	
	@Inject
	private JogosBD jogos;
	
	
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			jogos.salvarJogo(jogo);
			jogo = new Jogo();
			context.addMessage(null, new FacesMessage("Jogo salvo com sucesso!!!"));
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		}
	}
	
//	public void listarBandeirinha() {
//		bandeirinhas = badeirinhaBanco.all();		
//	}
	

	public Bandeirinha getBandeirinha() {
		return bandeirinha;
	}



	public void setBandeirinha(Bandeirinha bandeirinha) {
		this.bandeirinha = bandeirinha;
	}



	public Juiz getJuis() {
		return juis;
	}



	public void setJuis(Juiz juis) {
		this.juis = juis;
	}



	public Time getMandante() {
		return mandante;
	}



	public void setMandante(Time mandante) {
		this.mandante = mandante;
	}



	public Time getVisitante() {
		return visitante;
	}



	public void setVisitante(Time visitante) {
		this.visitante = visitante;
	}



	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public JogosBD getJogos() {
		return jogos;
	}

	public void setJogos(JogosBD jogos) {
		this.jogos = jogos;
	}
	
	
	
	

}
