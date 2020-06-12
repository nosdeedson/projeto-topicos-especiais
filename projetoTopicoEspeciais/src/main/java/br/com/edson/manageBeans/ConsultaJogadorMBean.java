package br.com.edson.manageBeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;

import br.com.edson.Model.Jogador;
import br.com.edson.repository.JogadoresBD;

@Named
@javax.faces.view.ViewScoped
public class ConsultaJogadorMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Jogador jogador;
	
	@Inject
	private Jogador jogadorSerExcluido;
	
	@Inject
	private JogadoresBD jogadoresBD;
	
	private List<Jogador> jogadores;
	
	@Inject
	private EntityManager em;
	
	public void buscarJogadores() {
		jogadores = jogadoresBD.todos();
	}
	
	public void excluir() {
		EntityTransaction et = em.getTransaction();
		FacesContext context = FacesContext.getCurrentInstance();
		
		try {
			et.begin();
			jogadoresBD.excluirJogador(jogadorSerExcluido);
			context.addMessage(null, new FacesMessage("Jogador excluído com sucesso!!!"));
			this.buscarJogadores();
			et.commit();

		} catch (Exception e) {
			et.rollback();
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
	}

	public Jogador getJogadorSerExcluido() {
		return jogadorSerExcluido;
	}

	public void setJogadorSerExcluido(Jogador jogadorSerExcluido) {
		this.jogadorSerExcluido = jogadorSerExcluido;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	
	

}
