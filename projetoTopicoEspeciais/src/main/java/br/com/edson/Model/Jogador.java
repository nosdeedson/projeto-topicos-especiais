package br.com.edson.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@DiscriminatorValue("J")
public class Jogador extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	private String posicao;
	private Time time;
	
	public Jogador() {
		super();
	}

	public Jogador(String posicao, Time time) {
		super();
		this.posicao = posicao;
		this.time = time;
	}
	
	@NotEmpty
	@Column (name = "posicao", length = 20, nullable = false)
	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	
	@NotNull
	@Column (name = "time", length = 20, nullable = false)
	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	
	
}
