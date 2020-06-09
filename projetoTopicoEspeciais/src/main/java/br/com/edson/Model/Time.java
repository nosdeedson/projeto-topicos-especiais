package br.com.edson.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "time")
public class Time implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idTime;
	private String nome;
	private int pontuacao;
	private List<Jogador> jogadores= new ArrayList<Jogador>();
	private List<Jogo> jogos = new ArrayList<Jogo>();
	
	public Time() {
	}

	public Time(String nome) {
		this.nome = nome;
	}
	
	@Id
	@GeneratedValue
	@Column(name = "id_time")
	public Long getIdTime() {
		return idTime;
	}

	public void setIdTime(Long idTime) {
		this.idTime = idTime;
	}

	@NotBlank
	@Column(name = "nome_time", nullable = false, length = 20)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@Column(name = "pontuacao")
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
	
	@NotNull
	@OneToMany(mappedBy = "time")
	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores( List<Jogador> jogadores) {
		this.jogadores= jogadores ;
	}
	
	@NotNull
	@OneToMany // talvez colocar joincolunm
	public List<Jogo> getJogos() {
		return jogos;
	}

	public void setJogos( List<Jogo> jogos) {
		this.jogos = jogos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idTime == null) ? 0 : idTime.hashCode());
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
		Time other = (Time) obj;
		if (idTime == null) {
			if (other.idTime != null)
				return false;
		} else if (!idTime.equals(other.idTime))
			return false;
		return true;
	}

}
