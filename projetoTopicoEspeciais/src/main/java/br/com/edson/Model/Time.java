package br.com.edson.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Time implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private int pontuacao;
	private List<Jogador> jogadores= new ArrayList<Jogador>();
	private List<Jogo> jogos = new ArrayList<Jogo>();
	
	public Time() {
	}

	public Time(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

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
		Time other = (Time) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
	

}
