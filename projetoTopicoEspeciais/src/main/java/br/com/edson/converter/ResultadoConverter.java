package br.com.edson.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.edson.Model.Resultado;
import br.com.edson.repository.ResultadosBD;


@FacesConverter(forClass = Resultado.class)
public class ResultadoConverter implements Converter {

	@Inject
	private ResultadosBD resultadosBD;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Resultado resultado = null;
		
		if( value != null && !"".equals(value) )
			resultado = resultadosBD.porId( new Long(value));
		return resultado;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Resultado resultado = null;
		if( value != null) {
			resultado = (Resultado) value;
			return resultado.getIdResultado() == null ? null : resultado.getIdResultado().toString();
		}
		return null;
	}

}
