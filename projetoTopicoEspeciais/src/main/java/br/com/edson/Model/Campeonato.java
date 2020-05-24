package br.com.edson.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "campeonato")
public class Campeonato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idCampeonato;
	private List<Time> colocacoes = new ArrayList<Time>();
	private Date dataInicio;
	private Date dataFim;
	private String nome;
	private String primeiroColocado;
	private String segundoColocado;
	private String terceiroColocado;
	private FormatoCampeonatoEnum tipoCampeonato;
	private List<Jogo> jogos = new ArrayList<Jogo>();
	
	public Campeonato() {
		super();
	}
	public Campeonato(Date dataInicio, Date dataFim, String nome) {
		super();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.nome = nome;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "id_campeonato", nullable = false)
	public Long getIdCampeonato() {
		return idCampeonato;
	}
	public void setIdCampeonato(Long idCampeonato) {
		this.idCampeonato = idCampeonato;
	}
	
	@OneToMany
	public List<Time> getColocacoes() {
		return colocacoes;
	}
	public void setColocacoes(List<Time> colocacoes) {
		this.colocacoes = colocacoes;
	}
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicio", nullable = false)
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	@NotNull
	@Temporal(TemporalType.DATE)
	@Column(name = "data_fim", nullable = false)
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	
	@NotBlank
	@Column(name = "nome", nullable = false, length = 20)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotBlank
	@Column(name = "primeiro_colocado", nullable = true, length = 20)
	public String getPrimeiroColocado() {
		return primeiroColocado;
	}
	public void setPrimeiroColocado(String primeiroColocado) {
		this.primeiroColocado = primeiroColocado;
	}
	
	@NotBlank
	@Column(name = "segundo_colocado", nullable = true, length = 20)
	public String getSegundoColocado() {
		return segundoColocado;
	}
	public void setSegundoColocado(String segundoColocado) {
		this.segundoColocado = segundoColocado;
	}
	
	@NotBlank
	@Column(name = "terceiro_colocado", nullable = true, length = 20)
	public String getTerceiroColocado() {
		return terceiroColocado;
	}
	public void setTerceiroColocado(String terceiroColocado) {
		this.terceiroColocado = terceiroColocado;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_campeonato")
	public FormatoCampeonatoEnum getTipoCampeonato() {
		return tipoCampeonato;
	}
	public void setTipoCampeonato(FormatoCampeonatoEnum tipoCampeonato) {
		this.tipoCampeonato = tipoCampeonato;
	}
	
	@OneToMany
	public List<Jogo> getJogos() {
		return jogos;
	}
	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}
	 	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idCampeonato == null) ? 0 : idCampeonato.hashCode());
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
		Campeonato other = (Campeonato) obj;
		if (idCampeonato == null) {
			if (other.idCampeonato != null)
				return false;
		} else if (!idCampeonato.equals(other.idCampeonato))
			return false;
		return true;
	}
	
	
	
}
