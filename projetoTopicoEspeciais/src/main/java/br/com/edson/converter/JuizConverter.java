package br.com.edson.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.edson.Model.Juiz;
import br.com.edson.Model.Time;
import br.com.edson.repository.JuizesBD;

@FacesConverter (forClass = Juiz.class)
public class JuizConverter implements Converter {

	@Inject
	private JuizesBD juizesBD;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Juiz juiz = null;
		
		if( value != null && !"".equals(value))
			juiz = juizesBD.porId(new Long(value));
		return juiz;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if( value != null) {
			Juiz juiz = (Juiz) value;
			return juiz.getId() == null ? null : juiz.getId().toString();
		}
		return null;
	}

}
