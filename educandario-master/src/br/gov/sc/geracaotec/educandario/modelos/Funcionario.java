package br.gov.sc.geracaotec.educandario.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "funcionarios")

public class Funcionario implements Serializable{

	private static final long serialVersionUID = 1L;

	// Há outras 3 tipo: AUTO, SEQUENCE, TABLE
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true)
	private Integer id;

	@Column(name = "nome", nullable = false, unique = true)
	private String nome;
		
	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date nascimento;

	@ManyToMany
	@JoinTable(name = "setores_funcionarios") // Olhar a inserção
	private List<Setor> setores;
	
	@Column(name = "deletado")
	private boolean deletado;

	public Funcionario() {
		this.setores = new ArrayList<Setor>();
		this.deletado = false;
	};

	public Funcionario(String nome, Date nascimento) {
		setNome(nome);
		setNascimento(nascimento);
		setores = new ArrayList<Setor>();
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

	public void setSetores(List<Setor> setores) {
		this.setores = setores;
	}

	public boolean isDeletado() {
		return deletado;
	}

	public void setDeletado(boolean deletado) {
		this.deletado = deletado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public List<Setor> getSetores() {
		return setores;
	}

	
	public void setSetores(Setor setor) {
		this.setores.add(setor);
	}
	
	public String getLista(){
		String setores = "";
		
		for(Setor s : this.setores){
			if (this.setores.size()==1){
				 return s.getNome();
			}
			setores += s.getNome() + ", ";
		}
		
		return setores;
	}
}
