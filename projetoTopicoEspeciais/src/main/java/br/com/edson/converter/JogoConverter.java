package br.com.edson.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import br.com.edson.Model.Jogo;
import br.com.edson.repository.JogosBD;

@FacesConverter(forClass = Jogo.class)
public class JogoConverter implements Converter {

	@Inject
	private JogosBD jogosBD;
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
		Jogo jogo = null;;

		if (value != null && !"".equals(value)) {
			jogo= jogosBD.porId( new Long(value));
		}
		return jogo;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Jogo jogo = (Jogo) value;
			return jogo.getIdJogo() == null ? null : jogo.getIdJogo().toString();
		}
		return null;
	}

}
