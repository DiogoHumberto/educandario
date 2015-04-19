package br.gov.sc.geracaotec.educandario.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;

import br.gov.sc.geracaotec.educandario.modelos.Aluno;
import br.gov.sc.geracaotec.educandario.util.JPA;
@FacesConverter("alunoConverter")
public class AlunoConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String s) {
		EntityManager em = JPA.getEM();
		
		
		return em.find(Aluno.class, Integer.parseInt(s));
	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic, Object s) {
		System.out.println(s.toString());
		Aluno a = (Aluno) s;
		return String.valueOf(a.getId());
		
	
	}

}
