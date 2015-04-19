package br.gov.sc.geracaotec.educandario.handlers;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.gov.sc.geracaotec.educandario.modelos.Aluno;
import br.gov.sc.geracaotec.educandario.modelos.Familiar;
import br.gov.sc.geracaotec.educandario.util.JPA;

@ManagedBean
@SessionScoped
public class FamiliarBean implements Serializable{

	private static final long serialVersionUID = 1L;


	@ManagedProperty("#{alunoBean}")
	private AlunoBean alunoBean;
	

	private Familiar familiar;
		
	
	public FamiliarBean(){
		this.familiar = new Familiar();
		
	}
	
	public  String addFamiliar(){
		EntityManager em = JPA.getEM();
		
		this.alunoBean.getAluno().getFamiliares().add(familiar);
				
		em.getTransaction().begin();
		em.merge(familiar);
		em.merge(this.alunoBean.getAluno());
		em.getTransaction().commit();
		this.alunoBean.setAluno(new Aluno());
		setFamiliar(new Familiar());
		return "/educandario/familiar/listar";
	}
	
	public String removeFamiliar(){
		EntityManager em  = JPA.getEM();
		this.familiar.setDeletado(true);
		
		em.getTransaction().begin();
		em.merge(familiar);
		em.getTransaction().commit();
		
		setFamiliar(new Familiar());
		return "/educandario/familiar/listar";
	}
	
	public List<Familiar> getFamiliares() {
		EntityManager em = JPA.getEM();
		TypedQuery<Familiar> query = em.createQuery("Select f from Familiar f WHERE f.deletado = false",
				Familiar.class);

		return query.getResultList();
	}
	public String editar(){
		return "/educandario/familiar/registrar";
	}
	
	public String clear(){
		this.familiar =new Familiar ();
		return "/educandario/familiar/registrar";
	}

	public Familiar getFamiliar() {
		return familiar;
	}

	public void setFamiliar(Familiar familiar) {
		this.familiar = familiar;
	}

	public void alteraDataEscolaridade(Date data){
		 this.familiar.setConculacaoEscolaridade(data);
	}
	public AlunoBean getAlunoBean() {
		System.out.println(alunoBean.getAluno().getNome());
		return alunoBean;
	}

	public void setAlunoBean(AlunoBean alunoBean) {
		this.alunoBean = alunoBean;
	}
	
	
}
