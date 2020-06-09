package br.com.edson.manageBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.edson.Model.Bandeirinha;
import br.com.edson.Model.Jogador;
import br.com.edson.Model.Jogo;
import br.com.edson.Model.Juiz;
import br.com.edson.Model.Time;
import br.com.edson.repository.BandeirinhasBD;
import br.com.edson.repository.JogosBD;
import br.com.edson.repository.JuizesBD;
import br.com.edson.repository.TimesBD;

@Named
@javax.faces.view.ViewScoped
public class CadastroJogosMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Bandeirinha bandeirinha;
	
	@Inject
	private BandeirinhasBD bandeirinhasBD;
	
	private List<Bandeirinha> bandeirinhas = new ArrayList<Bandeirinha>();
	
	@Inject
	private Juiz juiz;
	
	private List<Juiz> juizes = new ArrayList<Juiz>();
	
	@Inject
	private JuizesBD juizesBD;
	
	@Inject
	private Time time;
	
	private List<Time> times = new ArrayList<Time>();
	
	@Inject
	private TimesBD timesBD;
	
	@Inject
	private JogosBD jogosBD;
	
	@Inject
	private Jogo jogo;
	
	public void buscaBandeirinhas() {
		bandeirinhas = bandeirinhasBD.todos();
	}
	
	public void buscaJuizes() {
		juizes = juizesBD.todos();
	}
	
	public void buscaTimes() {
		times = timesBD.todos();
	}
	
	public void salvar() {
			FacesContext context = FacesContext.getCurrentInstance();
		
		try {

			jogosBD.salvarJogo(jogo);
			jogo = new Jogo();
			
			context.addMessage(null, new FacesMessage("Jogo salvo com sucesso!!!"));
		} catch (Exception e) {
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
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

	public Juiz getJuiz() {
		return juiz;
	}

	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}

	public List<Juiz> getJuizes() {
		return juizes;
	}

	public void setJuizes(List<Juiz> juizes) {
		this.juizes = juizes;
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
