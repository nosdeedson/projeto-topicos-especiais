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
import br.com.edson.Model.Jogador;
import br.com.edson.Model.Time;
import br.com.edson.repository.JogadoresBD;
import br.com.edson.repository.TimesBD;

@Named
@javax.faces.view.ViewScoped
public class CadastroJogadorMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Time time = new Time();

	private List<Time> times= new ArrayList<Time>();
	
	@Inject
	private TimesBD timesBD;
	
	@Inject
	private Jogador jogador;
	
	@Inject
	private JogadoresBD jogadoresBD;
	
	@Inject
	private EntityManager em;
	
	public void buscaTimes() {
		times = timesBD.todos();
	}
	
	
	public void salvar() {
		EntityTransaction et = em.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			et.begin();
			jogadoresBD.salvarJogador(jogador);
			jogador = new Jogador();
			context.addMessage(null, new FacesMessage("Jogador salvo com sucesso!!!"));
			et.commit();
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
		
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


	public Jogador getJogador() {
		return jogador;
	}


	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}
	
	
	
	
	
	

}
