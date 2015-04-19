package br.gov.sc.geracaotec.educandario.handlers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


	


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;

import br.gov.sc.geracaotec.educandario.modelos.Atendimento;
import br.gov.sc.geracaotec.educandario.util.JPA;

	@ManagedBean
	@SessionScoped
	public class AtendimentoBean implements Serializable{
	
		private static final long serialVersionUID = 1L;
		private Atendimento atendimento;
		
		public AtendimentoBean(){
			
			this.atendimento = new Atendimento();
			
		}
		
		public String addAtendimento(){
			//
			EntityManager em = JPA.getEM();
			
			em.getTransaction().begin();
			em.merge(atendimento);
			em.getTransaction().commit();
			
			setAtendimento(new Atendimento());
			return "/educandario/atendimento/listar"; //Arrumar Caminho
		}
		
		public String removeAtendimento(){
			EntityManager em = JPA.getEM();
			this.atendimento.setDeletado(true);	
			
			em.getTransaction().begin();
			em.merge(atendimento);
			em.getTransaction().commit();		
					
			setAtendimento(new Atendimento());
			return "/educandario/atendimento/listar";
		}
		
	public List<Atendimento> getAtendimentos() {
			EntityManager em = JPA.getEM();
			TypedQuery<Atendimento> query = em.createQuery("Select a from Atendimento a WHERE a.deletado = false",
					Atendimento.class);

			return query.getResultList();
		}
		public String clear(){
			this.atendimento =new Atendimento ();
			return "/educandario/atendimento/registrar";
		}

		public Atendimento getAtendimento() {
			return atendimento;
		}

		public void setAtendimento(Atendimento atendimento) {
			this.atendimento = atendimento;
		}

		public String editar(){
			return "/educandario/atendimento/registrar";
		}
		
		

//		public String funcionario(){
//			
//			EntityManager em = JPA.getEM();
//			
//			Funcionario funcionario = em.find(Funcionario.class, this.atendimento.getFuncionarioId());
//			
//			return funcionario.getNome();
////			TypedQuery<Funcionario> query = (TypedQuery<Funcionario>) em.find(Funcionario.class, this.atendimento.getFuncionarioId());
////			return query.getSingleResult();
//		}
//		
//		public String aluno(){
//			EntityManager em = JPA.getEM();
//			Aluno aluno = em.find(Aluno.class, this.atendimento.getAlunoId());
//			
//			return aluno.getNome();
//		}
	
		

	}


