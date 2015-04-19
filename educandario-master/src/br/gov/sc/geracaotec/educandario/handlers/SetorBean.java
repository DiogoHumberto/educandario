package br.gov.sc.geracaotec.educandario.handlers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.gov.sc.geracaotec.educandario.modelos.Funcionario;
import br.gov.sc.geracaotec.educandario.modelos.Setor;
import br.gov.sc.geracaotec.educandario.util.JPA;

@ManagedBean
@SessionScoped
public class SetorBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Setor setor;
	
	public SetorBean(){
		this.setor = new Setor();
				
	}

	public String addSetor(){
		EntityManager em = JPA.getEM();
		
		em.getTransaction().begin();
		em.merge(setor);
		em.getTransaction().commit();
		
		setSetor(new Setor());
		return "/educandario/setor/registrar"; //Arrumar Caminho
	}
	
	public String removeSetor(){
		
		EntityManager em = JPA.getEM();
		this.setor.setDeletado(true);
		
		em.getTransaction().begin();
		em.merge(setor);
		em.getTransaction().commit();
		
		setSetor(new Setor());
		return "/educandario/setor/listar";
	}
	
	public List<Setor> getSetores() {
		EntityManager em = JPA.getEM();
		TypedQuery<Setor> query = em.createQuery("Select s from Setor s WHERE s.deletado = false",
				Setor.class);

		return query.getResultList();
	}
	
	public String clear(){
		this.setor =new Setor ();
		return "/educandario/setor/registrar";
	}
	public String editar(){
		return "/educandario/setor/registrar";
	}
	
	public String responsavel(){
		EntityManager em = JPA.getEM();
		Funcionario responsavel = em.find(Funcionario.class, this.setor.getResponsavel().getId());
		
		return responsavel.getNome();
	}
	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}


	
	

}
