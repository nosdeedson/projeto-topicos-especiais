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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "resultado")
public class Resultado implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long idResultado;
	private boolean empate;
	private String perdedor; // recebo o nome do time
	private String vencedor; // recebe o nome do time
	
	public Resultado() {
	}


	@Id
	@GeneratedValue
	@Column(name = "id_resultado")
	public Long getIdResultado() {
		return idResultado;
	}

	public void setIdResultado(Long id) {
		this.idResultado = id;
	}
	
	@Column( name = "empate", nullable = true)	
	public boolean isEmpate() {
		return empate;
	}


	public void setEmpate(boolean empate) {
		this.empate = empate;
	}

	@Column(name = "perdedor", length = 20, nullable = true)
	public String getPerdedor() {
		return perdedor;
	}


	public void setPerdedor(String perdedor) {
		this.perdedor = perdedor;
	}

	@Column(name = "vencedor", length = 20, nullable = true)
	public String getVencedor() {
		return vencedor;
	}

	public void setVencedor(String vencedor) {
		this.vencedor = vencedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idResultado == null) ? 0 : idResultado.hashCode());
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
		if (idResultado == null) {
			if (other.idResultado != null)
				return false;
		} else if (!idResultado.equals(other.idResultado))
			return false;
		return true;
	}


}
