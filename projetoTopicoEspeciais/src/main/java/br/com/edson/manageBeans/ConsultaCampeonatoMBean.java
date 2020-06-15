package br.com.edson.manageBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;

import org.jboss.weld.context.RequestContext;

import br.com.edson.Model.Campeonato;
import br.com.edson.Model.Jogo;
import br.com.edson.Model.Resultado;
import br.com.edson.repository.CampeonatosBD;
import br.com.edson.repository.JogosBD;

@Named
@javax.faces.view.ViewScoped
public class ConsultaCampeonatoMBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Campeonato> torneios = new ArrayList<Campeonato>();
	
	@Inject
	private CampeonatosBD torneiosBD;
	
	@Inject
	private Campeonato torneio;
	
	@Inject
	private Campeonato torneioSerExcluido;
	
	private List<Jogo> jogos = new ArrayList<Jogo>();
	
	@Inject
	private JogosBD jogosBD;
	
	@Inject
	private Resultado resultado;
	
	private String winner;
	
	@Inject
	private EntityManager em;

	// metodos
	
	public void buscaCampeonato() {
		torneios = torneiosBD.todos();
	}
	
	public void excluir() {
		FacesContext context = FacesContext.getCurrentInstance();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			
			torneiosBD.excluirCampeonato(torneioSerExcluido);
			context.addMessage(null, new FacesMessage("Campeonato excluído com sucesso!!!"));
			et.commit();

		} catch (Exception e) {
			et.rollback();
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
		finally {
			torneio = new Campeonato();
			this.buscaCampeonato();
		}
	}
	
	public void exibirJogos() {
		jogos = jogosBD.todos(torneio.getIdCampeonato());		
	}
	
	// getters and setters
	
	public String getWinner() {
		return winner;
	}

	public Campeonato getTorneioSerExcluido() {
		return torneioSerExcluido;
	}

	public void setTorneioSerExcluido(Campeonato torneioSerExcluido) {
		this.torneioSerExcluido = torneioSerExcluido;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	public List<Campeonato> getTorneios() {
		return torneios;
	}


	public void setTorneios(List<Campeonato> torneios) {
		this.torneios = torneios;
	}

	public Campeonato getTorneio() {
		return torneio;
	}

	public void setTorneio(Campeonato torneio) {
		this.torneio = torneio;
	}

	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}
	
	
	
	

}
