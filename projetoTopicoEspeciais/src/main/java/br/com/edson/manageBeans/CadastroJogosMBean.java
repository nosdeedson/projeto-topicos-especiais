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
import br.com.edson.Model.Campeonato;
import br.com.edson.Model.Jogador;
import br.com.edson.Model.Jogo;
import br.com.edson.Model.Juiz;
import br.com.edson.Model.Time;
import br.com.edson.repository.BandeirinhasBD;
import br.com.edson.repository.CampeonatosBD;
import br.com.edson.repository.JogosBD;
import br.com.edson.repository.JuizesBD;
import br.com.edson.repository.TimesBD;

@Named
@javax.faces.view.ViewScoped
public class CadastroJogosMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private List<Bandeirinha> bandeirinhas = new ArrayList<Bandeirinha>();
	
	@Inject
	private BandeirinhasBD bandeirinhasBD;
	
	@Inject
	private Bandeirinha bandeirinha1;
	
	@Inject
	private Bandeirinha bandeirinha2;

	private List<Juiz> juizes = new ArrayList<Juiz>();	
	
	@Inject
	private Juiz juiz;
	
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Juiz getJuiz() {
		return juiz;
	}

	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}

	@Inject
	private JuizesBD juizesBD;
	
	private List<Time> times = new ArrayList<Time>();
	
	@Inject
	private TimesBD timesBD;
	
	@Inject
	private Time mandante;
	
	@Inject
	private Time visitante;
	
	@Inject
	private JogosBD jogosBD;
	
	@Inject
	private Jogo jogo = new Jogo();
	
	@Inject
	private EntityManager  em;
	
	private List<Campeonato> torneios = new ArrayList<Campeonato>();
	
	@Inject
	private CampeonatosBD torneioBD;
	
	public void buscaBandeirinhas() {
		bandeirinhas = bandeirinhasBD.todos();
	}
	
	public void buscaTorneio() {
		torneios = torneioBD.todos();
	}
	
	public void buscaJuizes() {
		juizes = juizesBD.todos();
	}
	
	public void buscaTimes() {
		times = timesBD.todos();
	}
	
	public void salvar() {
			FacesContext context = FacesContext.getCurrentInstance();
			EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			jogosBD.salvarJogo(jogo);
			jogo = new Jogo();
			context.addMessage(null, new FacesMessage("Jogo salvo com sucesso!!!"));
			et.commit();
		} catch (Exception e) {
			et.rollback();
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
	}

	public List<Bandeirinha> getBandeirinhas() {
		return bandeirinhas;
	}

	public void setBandeirinhas(List<Bandeirinha> bandeirinhas) {
		this.bandeirinhas = bandeirinhas;
	}

	public Bandeirinha getBandeirinha1() {
		return bandeirinha1;
	}

	public void setBandeirinha1(Bandeirinha bandeirinha1) {
		this.bandeirinha1 = bandeirinha1;
	}

	public Bandeirinha getBandeirinha2() {
		return bandeirinha2;
	}

	public void setBandeirinha2(Bandeirinha bandeirinha2) {
		this.bandeirinha2 = bandeirinha2;
	}

	public List<Juiz> getJuizes() {
		return juizes;
	}

	public void setJuizes(List<Juiz> juizes) {
		this.juizes = juizes;
	}

	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
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

	public List<Campeonato> getTorneios() {
		return torneios;
	}

	public void setTorneios(List<Campeonato> torneios) {
		this.torneios = torneios;
	}

	

}
