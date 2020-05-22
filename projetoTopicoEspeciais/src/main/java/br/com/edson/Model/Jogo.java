package br.com.edson.Model;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Jogo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private Date data;
	private LocalTime hora;
	private String local;
	private List<Time> times = new ArrayList<Time>();
	private Juiz juiz;
	private List<Bandeirinha> bandeirinhas = new ArrayList<Bandeirinha>();
	private Campeonato campeonato;
	private Resultado resultado;
	
	public Jogo() {
		super();
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data", nullable = false)
	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@NotNull
	@Temporal(TemporalType.TIME)
	@Column(name = "hora")
	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	@NotEmpty
	@Column(name = "local", length = 20, nullable = false)
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}
	
	@NotNull
	@OneToMany
	@JoinColumn(name= "id_time", nullable = false)
	public List<Time> getTimes() {
		return times;
	}

	public void setTimes(List<Time> times) {
		this.times = times;
	}
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "id_juiz")
	public Juiz getJuiz() {
		return juiz;
	}

	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}

	public List<Bandeirinha> getBandeirinhas() {
		return bandeirinhas;
	}

	public void setBandeirinhas(List<Bandeirinha> bandeirinhas) {
		this.bandeirinhas = bandeirinhas;
	}

	public Campeonato getCampeonato() {
		return campeonato;
	}

	public void setCampeonato(Campeonato campeonato) {
		this.campeonato = campeonato;
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
		Jogo other = (Jogo) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
}
