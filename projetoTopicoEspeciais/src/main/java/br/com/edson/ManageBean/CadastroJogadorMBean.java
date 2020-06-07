package br.com.edson.ManageBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.edson.Model.Jogador;
import br.com.edson.Model.Time;
import br.com.edson.repository.JogadoresBD;
import br.com.edson.repository.TimesBD;

@Named
@javax.faces.view.ViewScoped
public class CadastroJogadorMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Jogador jogador;
	
	@Inject
	private JogadoresBD jogadores;
	
	@Inject
	private TimesBD timesBanco;
	
	@Inject
	private Time time;
	
	
	private List<Time> times = new ArrayList<Time>();
	
	public void salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		try {
			jogadores.salvarJogadores(jogador);
			jogador = new Jogador();
			context.addMessage(null, new FacesMessage("Jogador salvo com sucesso!!!"));
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
		
	}
	
	public void listarTimes() {
		times = timesBanco.all();
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}
	

	
	
	
	
	
	
	
}
