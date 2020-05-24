package br.com.edson.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "jogo")
public class Jogo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idJogo;
	private Bandeirinha bandeira1;
	private Bandeirinha bandeira2;
	private Date data;
	private Date hora;
	private Juiz juiz;
	private String local;
	private Time timeCasa;
	private Time visitante;
	private Resultado resultado;
	
	public Jogo() {
		super();
	}

	public Jogo(Bandeirinha bandeira1, Bandeirinha bandeira2, Date data, Date hora, Juiz juiz,
			String local, Time timeCasa, Time visitante) {
		
		this.bandeira1 = bandeira1;
		this.bandeira2 = bandeira2;
		this.data = data;
		this.hora = hora;
		this.juiz = juiz;
		this.local = local;
		this.timeCasa = timeCasa;
		this.visitante = visitante;
	}

	@Id
	@GeneratedValue
	@Column(name = "id_jogo")
	public Long getIdJogo() {
		return idJogo;
	}

	public void setIdJogo(Long idJogo) {
		this.idJogo = idJogo;
	}
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "id_badeira1", nullable = false)
	public Bandeirinha getBandeira1() {
		return bandeira1;
	}

	public void setBandeira1(Bandeirinha bandeira1) {
		this.bandeira1 = bandeira1;
	}
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "id_badeira2", nullable = false)
	public Bandeirinha getBandeira2() {
		return bandeira2;
	}

	public void setBandeira2(Bandeirinha bandeira2) {
		this.bandeira2 = bandeira2;
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

	@Temporal(TemporalType.TIME)
	@Column(name = "hora", nullable = true)
	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "id_juiz", nullable = false)
	public Juiz getJuiz() {
		return juiz;
	}

	public void setJuiz(Juiz juiz) {
		this.juiz = juiz;
	}
	
	@NotNull
	@Column(name = "local", length = 20, nullable = false)
	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	@NotNull
	@OneToOne
	@JoinColumn( name = "id_time_casa", nullable = false)
	public Time getTimeCasa() {
		return timeCasa;
	}

	public void setTimeCasa(Time timeCasa) {
		this.timeCasa = timeCasa;
	}
	
	@NotNull
	@OneToOne
	@JoinColumn( name = "id_visitante", nullable = false)
	public Time getVisitante() {
		return visitante;
	}

	public void setVisitante(Time visitante) {
		this.visitante = visitante;
	}
	
	@OneToOne
	@JoinColumn(name = "id_resultado")
	public Resultado getResultado() {
		return resultado;
	}

	public void setResultado(Resultado resultado) {
		this.resultado = resultado;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idJogo == null) ? 0 : idJogo.hashCode());
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
		if (idJogo == null) {
			if (other.idJogo != null)
				return false;
		} else if (!idJogo.equals(other.idJogo))
			return false;
		return true;
	}
	
	
	
	
	
}
