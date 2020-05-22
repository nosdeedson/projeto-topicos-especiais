package br.com.edson.Model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("B")
public class Bandeirinha extends Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

}
