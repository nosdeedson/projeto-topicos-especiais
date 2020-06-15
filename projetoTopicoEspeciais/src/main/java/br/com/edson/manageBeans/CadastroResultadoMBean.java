package br.com.edson.manageBeans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.swing.JOptionPane;

import br.com.edson.Model.Jogo;
import br.com.edson.Model.Resultado;
import br.com.edson.repository.JogosBD;
import br.com.edson.repository.ResultadosBD;
import br.com.edson.repository.TimesBD;

@Named
@javax.faces.view.ViewScoped
public class CadastroResultadoMBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Jogo jogo;
	
	@Inject
	private Resultado resultado;
	
	@Inject
	private ResultadosBD resultadosBD;
	
	@Inject
	private JogosBD jogosBD;

	@Inject
	private EntityManager em;
	
	@Inject
	private TimesBD timesBD;
	
	private String winner = "";
	
	public String salvar() {
		
		FacesContext context = FacesContext.getCurrentInstance();
		EntityTransaction et = em.getTransaction();
		
		try {			
			et.begin();
			if(getWinner().equals("empate")) {
				resultado.setEmpate(true);
				jogo.getTimeCasa().setPontuacao(1);
				timesBD.salvarTime(jogo.getTimeCasa());
				jogo.getVisitante().setPontuacao(1);
				timesBD.salvarTime(jogo.getVisitante());
			}
			else if( getWinner().equals(jogo.getTimeCasa().getNome())) {
				resultado.setVencedor(jogo.getTimeCasa().getNome());
				jogo.getTimeCasa().setPontuacao(3);
				timesBD.salvarTime(jogo.getTimeCasa());
			}
			else {
				resultado.setVencedor(jogo.getVisitante().getNome());
				jogo.getVisitante().setPontuacao(3);
				timesBD.salvarTime(jogo.getVisitante());
			}
			
		
			Long id = resultadosBD.salvarResultado(resultado);
			//et.commit();
			resultado.setIdResultado(id);
			
			jogo.setResultado(resultado);
			//et.begin();
			jogosBD.salvarJogo(jogo);
			et.commit();
			context.addMessage(null, new FacesMessage("Resultado salvo com sucesso!!!"));
			return "consultaCampeonato?faces-redirect=true";
			
		} catch (Exception e) {
			et.rollback();
			e.printStackTrace();
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
		return null;
	}
	
	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}
	
	
	

}
