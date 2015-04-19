package br.gov.sc.geracaotec.educandario.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("telefoneConverter")
public class TelefoneConverter implements Converter {

	public Object getAsObject(FacesContext fc, UIComponent uic, String s) {
		Long l = Long.parseLong(s.replaceAll("\\D", ""));
		return l;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object o) {
		String t = String.valueOf((Long) o);
		return "(" + t.substring(0, 2) + ") " + t.substring(2, 6) + "-"
				+ t.substring(6);
	}

}
