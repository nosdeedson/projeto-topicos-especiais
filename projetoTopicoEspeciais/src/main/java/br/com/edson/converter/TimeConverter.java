package br.com.edson.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.edson.Model.Time;
import br.com.edson.repository.TimesBD;


@FacesConverter (forClass = Time.class)
public class TimeConverter implements Converter {

	@Inject
	private TimesBD timesBD;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Time time = null;
		
		if( value != null && !"".equals(value))
			time = timesBD.porId( new Long(value));
		return time;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if( value != null) {
			Time time = (Time) value;
			return time.getIdTime() == null ? null : time.getIdTime().toString();
		}
		return null;
	}

}
