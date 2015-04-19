package br.gov.sc.geracaotec.educandario.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.gov.sc.geracaotec.educandario.modelos.Funcionario;
import br.gov.sc.geracaotec.educandario.util.JPA;

@FacesConverter("funcioarioConverter")
public class FuncionarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String s) {
		System.out.println(s);
		EntityManager em = JPA.getEM();
		
		return em.find(Funcionario.class, Integer.parseInt(s));
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object s) {
		System.out.println(s.toString());
		Funcionario f = (Funcionario) s;
		return String.valueOf(f.getId());
	}

}
