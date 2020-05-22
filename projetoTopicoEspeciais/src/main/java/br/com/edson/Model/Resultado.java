package br.com.edson.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Resultado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private List<Time> empate = new ArrayList<Time>();
	private Time perdedor;
	private Time vencedor;
	private Jogo jogo;
	
	public Resultado() {
	}

	public Resultado( Jogo jogo) {
		this.jogo = jogo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Time> getEmpate() {
		return empate;
	}

	public void setEmpate(List<Time> empate) {
		this.empate = empate;
	}

	public Time getPerdedor() {
		return perdedor;
	}

	public void setPerdedor(Time perdedor) {
		this.perdedor = perdedor;
	}

	public Time getVencedor() {
		return vencedor;
	}

	public void setGanhador(Time vencedor) {
		this.vencedor = vencedor;
	}

	public Jogo getJogo() {
		return jogo;
	}

	public void setJogo(Jogo jogo) {
		this.jogo = jogo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resultado other = (Resultado) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
