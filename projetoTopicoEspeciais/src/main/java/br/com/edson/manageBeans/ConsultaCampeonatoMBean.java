package br.com.edson.manageBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.swing.JOptionPane;

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
	
	private List<Jogo> jogos = new ArrayList<Jogo>();
	
	@Inject
	private JogosBD jogosBD;
	
	@Inject
	private Resultado resultado;
	
	
	
	public void buscaCampeonato() {
		torneios = torneiosBD.todos();
	}
	
	public void exibirJogos() {
		jogos = jogosBD.todos(torneio.getIdCampeonato());		
	}
	
	public void salvarResultado() {
		JOptionPane.showMessageDialog(null, resultado.getVencedor());
	}
	
	// getters and setters
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
