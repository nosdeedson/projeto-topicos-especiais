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

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "campeonato")
public class Campeonato implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private List<Time> colocacao = new ArrayList<Time>();
	private Date dataInicio;
	private Date dataFim;
	private String nome;
	private List<Time> premiacao = new ArrayList<Time>();
	private List<Jogo> jogos = new ArrayList<Jogo>();
	private List<Resultado> resultados = new ArrayList<Resultado>();
	private FormatoCampeonatoEnum formato;

	public Campeonato() {
		super();
	}

	public Campeonato(Date dataInicio, Date dataFim, String nome, List<Jogo> jogos, FormatoCampeonatoEnum formato) {
		super();
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.nome = nome;
		this.jogos = jogos;
		this.formato = formato;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@NotNull
	@OneToMany
	@JoinColumn (name = "id_time")
	public List<Time> getColocacao() {
		return colocacao;
	}

	public void setColocacao(List<Time> colocacao) {
		this.colocacao = colocacao;
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

	@NotEmpty
	@Column(name = "nome", length = 20, nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToMany
	@JoinColumn (name = "id_time")
	@Column (name = "premiacao", nullable = true)
	public List<Time> getPremiacao() {
		return premiacao;
	}

	public void setPremiacao(List<Time> premiacao) {
		this.premiacao = premiacao;
	}
	
	@NotNull
	@OneToMany
	@JoinColumn(name = "id_jogo")
	@Column (name = "jogo", nullable = false)
	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos(List<Jogo> jogos) {
		this.jogos = jogos;
	}
	
	@OneToMany
	@JoinColumn(name = "id_resultado")
	@Column (name = "id_resultado", nullable = true)
	public List<Resultado> getResultados() {
		return resultados;
	}

	public void setResultados(List<Resultado> resultados) {
		this.resultados = resultados;
	}
	
	@NotNull
	@Enumerated (EnumType.STRING)
	@Column(name = "formato", nullable = false)
	public FormatoCampeonatoEnum getFormato() {
		return formato;
	}

	public void setFormato(FormatoCampeonatoEnum formato) {
		this.formato = formato;
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
		Campeonato other = (Campeonato) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	

}
