package br.com.edson.Model;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("JU")
public class Juiz extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

}
