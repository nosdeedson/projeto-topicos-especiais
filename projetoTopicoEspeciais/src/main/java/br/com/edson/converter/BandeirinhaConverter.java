package br.com.edson.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.edson.Model.Bandeirinha;
import br.com.edson.repository.BandeirinhasBD;

@FacesConverter(forClass = Bandeirinha.class)
public class BandeirinhaConverter implements Converter {
	
	@Inject
	private BandeirinhasBD bandeirinhasBD;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Bandeirinha retorno = null;

		if (value != null && !"".equals(value)) {
			retorno = bandeirinhasBD.porId(new Long(value));
		}
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Bandeirinha bandeirinha = (Bandeirinha) value;
			return bandeirinha.getId() == null ? null : bandeirinha.getId().toString();
		}
		return null;
	}

}
