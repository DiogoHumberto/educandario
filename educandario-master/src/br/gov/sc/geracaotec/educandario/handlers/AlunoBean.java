package br.gov.sc.geracaotec.educandario.handlers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.event.ValueChangeEvent;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.gov.sc.geracaotec.educandario.modelos.Aluno;
import br.gov.sc.geracaotec.educandario.util.JPA;

@ManagedBean
@SessionScoped
public class AlunoBean implements Serializable {

	private static final long serialVersionUID = 3644098576105756214L;

	
	private Aluno aluno;

	public AlunoBean() {
		this.aluno = new Aluno();
	}

	public String addAluno() {
		EntityManager em = JPA.getEM();

		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();

		setAluno(new Aluno());
		return "/educandario/aluno/registrar"; // Arrumar Caminho
	}

	public String removeAluno() {
		
		EntityManager em = JPA.getEM();
		//altera campo de deletado
		
		this.aluno.setDeletado(true);
		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();		

		setAluno(new Aluno());
		return "/educandario/aluno/listar";
	}

	public List<Aluno> getAlunos() {
		EntityManager em = JPA.getEM();
		TypedQuery<Aluno> query = em.createQuery("Select a from Aluno a WHERE a.deletado = false",
				Aluno.class);

		return query.getResultList();
	}

	public void numeroNis(ValueChangeEvent e)  {

		UIComponent uicBolsa = e.getComponent();
		System.out.println(uicBolsa.getAttributes().get("value"));
		String valor = String.valueOf(uicBolsa.getAttributes().get("value"));

		if (valor.equals("true")) {
			uicBolsa.findComponent("numeroCad").getAttributes().put("disabled", false);
		} else {
			uicBolsa.findComponent("numeroCad").getAttributes().put("disabled", true);
		}

	}

	public String editar() {
		setAluno(aluno);
		return "/educandario/aluno/registrar";
	}

	public String addFamiliar() {
		setAluno(aluno);
		return "/educandario/familiar/registrar"; // Pagina
	}

	public String clear() {
		this.aluno = new Aluno();
		return "/educandario/aluno/registrar";
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
