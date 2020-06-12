package br.com.edson.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.edson.Model.Jogador;
import br.com.edson.Model.Juiz;
import br.com.edson.repository.JogadoresBD;
import br.com.edson.repository.JuizesBD;

@FacesConverter(forClass = Jogador.class)
public class JogadorConverter implements Converter {

	@Inject
	private JogadoresBD jogadoresBD;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Jogador jogador = null;
		
		if( value != null && !"".equals(value))
			jogador = jogadoresBD.porId( new Long(value));
		return jogador;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if( value != null) {			
			Jogador jogador = (Jogador) value;
			return jogador.getId() == null ? null : jogador.getId().toString();
		}
		return null;
	}

}
