package br.gov.sc.geracaotec.educandario.modelos;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.junit.BeforeClass;
import org.junit.Test;

public class SetorTest {

	// O EntityManager é reponsável por alterar os estados
	private static EntityManager em;

	@BeforeClass
	public static void startEntityManager() throws Exception {
		// classe EntityManagerFactory, responsável por carregar as
		// configurações da unidade
		// de persistência para dentro do EntityManager
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("educandario-test");
		em = emf.createEntityManager();
	}
	
	@Test
	public void adicaoFuncionarioComoReponsavel() {
		Funcionario f = new Funcionario("Tiago Potter", LocalDate.of(1960, 3, 27));
		Setor setor = new Setor("Grifinória");
		setor.setResponsavel(f);
		
		em.getTransaction().begin();
		em.persist(f);
		em.persist(setor);
		em.getTransaction().commit();
		
		TypedQuery<Setor> query = em.createQuery(
				"select s from Setor s where s.nome = :nome",
				Setor.class);
		query.setParameter("nome", "Grifinória");
		Setor sQuery = query.getSingleResult();
		
		assertThat(f, is(sQuery.getResponsavel()));
	}
	
	@Test(expected = RollbackException.class)
	public void remocaoNaoSeguraReponsavel() {
		Funcionario f = new Funcionario("Potter", LocalDate.of(1960, 3, 27));
		Setor setor = new Setor("Grifinóriaa");
		setor.setResponsavel(f);
		
		em.getTransaction().begin();
		em.persist(f);
		em.persist(setor);
		em.getTransaction().commit();
		
		// remoção não segura
		em.getTransaction().begin();
		em.remove(f);
		em.getTransaction().commit();
	}

	// Teste tenta inserir um setor sem nome, que deve resultar em uma
	// falha por conta da configuração da coluna na classe Setor
	@Test(expected = RollbackException.class)
	public void nomeObrigatorio() {
		Setor setor = new Setor();
		em.getTransaction().begin();
		em.persist(setor);
		em.getTransaction().commit();
	}
	
	// Testa se um nome de setor deve ser único
	@Test(expected = RollbackException.class)
	public void nomeUnico() {
		Setor setorUm = new Setor();
		setorUm.setNome("Herbalismo");
		
		Setor setorDois = new Setor();
		setorDois.setNome("Herbalismo");
		
		em.getTransaction().begin();
		em.persist(setorUm);
		em.persist(setorDois);
		em.getTransaction().commit();
	}
	
	@Test
	public void adicionarFuncionariosSetor() {
		Funcionario fUm = new Funcionario("Harry Tiago Potter", LocalDate.of(1980, 7, 31));
		Funcionario fDois = new Funcionario("Rúbeo Hagrid", LocalDate.of(1928, 12, 6));
		Funcionario fTres = new Funcionario("Tom Servolo Riddle", LocalDate.of(1926, 12, 31));
		
		Setor setorUm = new Setor("Hogwarts");
		setorUm.addFuncionario(fUm);
		setorUm.addFuncionario(fDois);
		setorUm.addFuncionario(fTres);
		
		em.getTransaction().begin();
		em.persist(fUm);
		em.persist(fDois);
		em.persist(fTres);
		em.persist(setorUm);
		em.getTransaction().commit();
		
		TypedQuery<Setor> query = em.createQuery(
				"select s from Setor s where s.nome = :nome",
				Setor.class);
		query.setParameter("nome", "Hogwarts");
		Setor sQuery = query.getSingleResult();
		
		assertThat(setorUm.getFuncionarios(), is(sQuery.getFuncionarios()));
	}
	
	@Test(expected = RollbackException.class)
	public void remocaoNaoSeguraFuncionarioSetor() {
		Funcionario fUm = new Funcionario("Horácio E. F. Slughorn", LocalDate.of(1881, 6, 3));
		Funcionario fDois = new Funcionario("Severo Snape", LocalDate.of(1960, 1, 9));
		
		Setor setor = new Setor("Poções");
		setor.addFuncionario(fUm);
		setor.addFuncionario(fDois);
		
		em.getTransaction().begin();
		em.persist(fUm);
		em.persist(fDois);
		em.persist(setor);
		em.getTransaction().commit();
		
		TypedQuery<Setor> query = em.createQuery(
				"select s from Setor s where s.nome = :nome",
				Setor.class);
		query.setParameter("nome", "Poções");
		Setor sQuery = query.getSingleResult();
		
		assertThat(setor.getFuncionarios(), is(sQuery.getFuncionarios()));
		
		em.getTransaction().begin();
		em.remove(fUm);
		em.getTransaction().commit();
	}
	
	@Test
	public void remocaoSeguraFuncionarioSetor() {
		Funcionario fUm = new Funcionario("Horácio E. F. Slughorn", LocalDate.of(1881, 6, 3));
		Funcionario fDois = new Funcionario("Severo Snape", LocalDate.of(1960, 1, 9));
		
		Setor setor = new Setor("Poçõess");
		setor.addFuncionario(fUm);
		setor.addFuncionario(fDois);
		
		em.getTransaction().begin();
		em.persist(fUm);
		em.persist(fDois);
		em.persist(setor);
		em.getTransaction().commit();
		
		TypedQuery<Setor> query = em.createQuery(
				"select s from Setor s where s.nome = :nome",
				Setor.class);
		query.setParameter("nome", "Poçõess");
		Setor sQuery = query.getSingleResult();
		
		assertThat(setor.getFuncionarios(), is(sQuery.getFuncionarios()));
		
		setor.removeFuncionario(fUm);
		
		em.getTransaction().begin();
		em.persist(setor);
		em.remove(fUm);
		em.getTransaction().commit();
		
		query = em.createQuery(
				"select s from Setor s where s.nome = :nome",
				Setor.class);
		query.setParameter("nome", "Poçõess");
		sQuery = query.getSingleResult();
		
		assertThat(setor.getFuncionarios(), is(sQuery.getFuncionarios()));
	}
}
