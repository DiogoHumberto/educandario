package br.gov.sc.geracaotec.educandario.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.gov.sc.geracaotec.educandario.modelos.Setor;
import br.gov.sc.geracaotec.educandario.util.JPA;

@FacesConverter("setorConverter")
public class SetorConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String s) {
		System.out.println(s);
		EntityManager em = JPA.getEM();
		
		return em.find(Setor.class, Integer.parseInt(s));
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object s) {
		System.out.println(s.toString());
		Setor setor = (Setor) s;
		return String.valueOf(setor.getId());
	}

}
