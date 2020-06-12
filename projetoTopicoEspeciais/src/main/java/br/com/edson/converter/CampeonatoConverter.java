package br.com.edson.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.edson.Model.Campeonato;
import br.com.edson.repository.CampeonatosBD;

@FacesConverter(forClass = Campeonato.class)
public class CampeonatoConverter implements Converter {
	
	@Inject
	CampeonatosBD campeonatoBD;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Campeonato campeonato= null;
		
		if( value != null && !"".equals(value))
			campeonato = campeonatoBD.porId(new Long(value));
		return campeonato;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null) {
			Campeonato campeonato = (Campeonato) value;
			return campeonato.getIdCampeonato() == null ? null : campeonato.getIdCampeonato().toString();
		}
		return null;
	}

}
