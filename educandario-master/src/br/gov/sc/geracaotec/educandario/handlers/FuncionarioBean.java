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
public class FuncionarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Funcionario funcionario;
	private Setor setor;

	public FuncionarioBean() {
		this.funcionario = new Funcionario();
		this.setor = new Setor();
	}

	public String addFuncionario() {
		EntityManager em = JPA.getEM();
		
		em.getTransaction().begin();
		em.merge(funcionario);
		
		em.getTransaction().commit();
		
		setFuncionario(new Funcionario());
		return "/educandario/funcionario/listar";
	}

	public String removeFamiliar() {
		EntityManager em = JPA.getEM();
		this.funcionario.setDeletado(true);
		
		em.getTransaction().begin();
		em.merge(funcionario);
		em.getTransaction().commit(); //Verificar o q falta
		
		setFuncionario(new Funcionario());
		return "/educandario/funcionario/listar";
	}
	
	public List<Funcionario> getFuncionarios() {
		EntityManager em = JPA.getEM();
		TypedQuery<Funcionario> query = em.createQuery("Select f from Funcionario f WHERE f.deletado = false",
				Funcionario.class);

		return query.getResultList();
	}
	public String clear() {
		this.funcionario = new Funcionario();
		return "/educandario/funcionario/registrar";
	}
	public String editar(){
		return "/educandario/funcionario/registrar";
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}


	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor novo) {
		
		for(Setor s : this.funcionario.getSetores()){
			if(s.equals(novo)){
				return;
			}
		}
		
		this.funcionario.getSetores().add(novo);
		this.setor = novo;
	}

//	public String novoSetor(){
//		return "/educandario/funcionario/setor";
//	}
//	
//	public String addSetor(){
//		for(Setor s : this.funcionario.getSetores()){
//			if(s.equals(s)){
//				return "";
//			}
//		}
//		
//		this.funcionario.getSetores().add(setor);
//		this.setor = setor;
//		
//		EntityManager em = JPA.getEM();
//		this.funcionario.setDeletado(true);
//		
//		em.getTransaction().begin();
//		em.merge(funcionario);
//		em.getTransaction().commit(); //Verificar o q falta
//		
//		setFuncionario(new Funcionario());
//		return "/educandario/funcionario/listar";
//		
//		return "";
//		
//	}
	
	
	

}
