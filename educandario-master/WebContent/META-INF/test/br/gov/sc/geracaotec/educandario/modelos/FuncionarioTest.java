package br.gov.sc.geracaotec.educandario.modelos;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import javax.persistence.TypedQuery;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class FuncionarioTest {

	// O EntityManager é reponsável por alterar os estados
	private static EntityManager em;
	private Funcionario funcionario;

	@BeforeClass
	public static void startEntityManager() throws Exception {
		// classe EntityManagerFactory, responsável por carregar as
		// configurações da unidade de persistência para dentro do 
		// EntityManager
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("educandario-test");
		em = emf.createEntityManager();
	}
	
	@Before
	public void configuraObjetos() {
		funcionario = new Funcionario();
		funcionario.setNome("Nassor Paulino da Silva");
		funcionario.setNascimento(LocalDate.of(1984, 7, 3));
		
//		em.getTransaction().begin();
//		em.createNativeQuery("delete from funcionarios_setores").executeUpdate();
//		em.createNativeQuery("delete from setores").executeUpdate();
//		em.createNativeQuery("delete from funcionarios").executeUpdate();
//		em.getTransaction().commit();
	}

//	@Test
//	public void findByIdTest() {
//		em.getTransaction().begin();
//		em.persist(funcionario);
//		em.getTransaction().commit();
//		
//		Funcionario f = em.find(Funcionario.class, 1);
//		Assert.assertEquals("Nassor Paulino da Silva", f.getNome());
//
//		// Verificando se o objeto buscado é de fato o mesmo que foi inserido.
//		assertEquals(1984, f.getNascimento().getYear());
//		assertEquals(7, f.getNascimento().getMonthValue());
//		assertEquals(3, f.getNascimento().getDayOfMonth());
//	}
//
//	@Test
//	public void findByNomeTest() {
//		em.getTransaction().begin();
//		em.persist(funcionario);
//		em.getTransaction().commit();
//		
//		TypedQuery<Funcionario> query = em.createQuery(
//				"select f from Funcionario f where f.nome = :nome",
//				Funcionario.class);
//		query.setParameter("nome", "Nassor Paulino da Silva");
//		Funcionario f = query.getSingleResult();
//
//		// Verificando se o objeto buscado é de fato o mesmo que foi inserido.
//		assertEquals("Nassor Paulino da Silva", f.getNome());
//		assertEquals(1984, f.getNascimento().getYear());
//		assertEquals(7, f.getNascimento().getMonthValue());
//		assertEquals(3, f.getNascimento().getDayOfMonth());
//	}
//
//	@Test
//	public void findByNascimentoTest() {
//		em.getTransaction().begin();
//		em.persist(funcionario);
//		em.getTransaction().commit();
//		
//		TypedQuery<Funcionario> query = em.createQuery(
//				"select f from Funcionario f where f.nascimento = :data",
//				Funcionario.class);
//		query.setParameter("data", LocalDate.of(1984, 7, 3));
//		Funcionario f = query.getSingleResult();
//
//		// Verificando se o objeto buscado é de fato o mesmo que foi inserido.
//		assertEquals("Nassor Paulino da Silva", f.getNome());
//		assertEquals(1984, f.getNascimento().getYear());
//		assertEquals(7, f.getNascimento().getMonthValue());
//		assertEquals(3, f.getNascimento().getDayOfMonth());
//	}
//
//	// Teste tenta inserir um funcionario sem nome, que deve resultar em uma
//	// falha
//	// por conta da configuração da coluna na classe Funcionario
//	@Test(expected = RollbackException.class)
//	public void nomeObrigatorio() {
//		funcionario.setNome(null);
//		em.getTransaction().begin();
//		em.persist(funcionario);
//		em.getTransaction().commit();
//	}
//
//	// Teste tenta inserir um funcionario sem data de nascimento, que deve
//	// resultar em uma falha
//	// por conta da configuração da coluna na classe Funcionario
//	@Test(expected = RollbackException.class)
//	public void nascimentoObrigatorio() {
//		Funcionario funcionario = new Funcionario();
//		funcionario.setNascimento(null);
//		em.getTransaction().begin();
//		em.persist(funcionario);
//		em.getTransaction().commit();
//	}
//
//	// Testa a atualização de uma linha na base de dados
//	@Test
//	public void atualizacaoTest() {
//		// Adicionando um novo funcionário no banco de dados para realizar o
//		// teste
//		Funcionario funcionario = new Funcionario();
//		funcionario = new Funcionario();
//		funcionario.setNome("Nassor Paulino");
//		funcionario.setNascimento(LocalDate.of(1984, 7, 3));
//		
//		em.getTransaction().begin();
//		em.persist(funcionario);
//		em.getTransaction().commit();
//
//		// Alterando os dados do funcionario
//		Integer fId = funcionario.getId();
//		funcionario.setNome("Nassor Paulino da Silva");
//		em.getTransaction().begin();
//		em.persist(funcionario);
//		em.getTransaction().commit();
//
//		// Verificando se a mudança foi realmente efetuada
//		Funcionario fAtualizado = em.find(Funcionario.class, fId);
//		assertEquals("Nassor Paulino da Silva", fAtualizado.getNome());
//		assertEquals(1984, fAtualizado.getNascimento().getYear());
//		assertEquals(7, fAtualizado.getNascimento().getMonthValue());
//		assertEquals(3, fAtualizado.getNascimento().getDayOfMonth());
//	}
//
//	// Testa a remoção de uma linha na base de dados
//	@Test
//	public void remocaoTest() {
//		// Adicionando um novo funcionário no banco de dados para realizar o
//		// teste
//		em.getTransaction().begin();
//		em.persist(funcionario);
//		em.getTransaction().commit();
//
//		// Recuperando o dado inserido no banco de dados dado
//		Integer fId = funcionario.getId();
//		Funcionario f = em.find(Funcionario.class, fId);
//
//		// Removendo o dado do banco de dados
//		em.getTransaction().begin();
//		em.remove(f);
//		em.getTransaction().commit();
//
//		// Verificando se o dado foi realmente removido
//		Funcionario fRemovido = em.find(Funcionario.class, fId);
//		assertNull(fRemovido);
//	}
	
	// Testa a capacidade do funcionário saber quais são seus setores
	@Test
	public void funcionariosSetores() {
		Setor sUm = new Setor("Setor 1");
		Setor sDois = new Setor("Setor 2");
		
		sUm.addFuncionario(funcionario);
		sDois.addFuncionario(funcionario);
		funcionario.getSetores().add(sUm);
		funcionario.getSetores().add(sDois);
		
		em.getTransaction().begin();
		em.persist(funcionario);
		em.persist(sUm);
		em.persist(sDois);
		em.getTransaction().commit();
		
		TypedQuery<Setor> query = em.createQuery(
				"SELECT s FROM Funcionario f JOIN f.setores s WHERE f.nome = :nome",
				Setor.class);
		query.setParameter("nome", funcionario.getNome());
		
		TypedQuery<Funcionario> queryFuncionario = em.createQuery(
				"SELECT f FROM Funcionario f WHERE f.nome = :nome",
				Funcionario.class);
		queryFuncionario.setParameter("nome", funcionario.getNome());
		
		// Comparando a lista de setores 
		assertThat(queryFuncionario.getSingleResult().getSetores(), 
				is(query.getResultList()));
		
		em.getTransaction().begin();
		em.remove(sUm);
		em.remove(sDois);
		em.remove(funcionario);
		em.getTransaction().commit();
		
	}
}
