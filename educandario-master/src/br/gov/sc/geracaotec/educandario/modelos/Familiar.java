package br.gov.sc.geracaotec.educandario.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="responsaveis")
public class Familiar implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	
	@Column(name = "tipo_parentesco")
	private String tipoParentesco;
	
	@Column(name = "CPF")
	private String CPF;
	
	@Column(name = "RG")
	private String RG;
	
	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	
	@Column(name = "escolaridade")
	private String escolaridade;
	
	@Column(name = "data_conclusao_escolaridade")
	@Temporal(TemporalType.DATE)
	private Date conclusaoEscolaridade;
	
	@Column(name = "observacao")
	private String observacao;
	
	@Column(name = "renda")
	private Float renda;
	
	@Column(name = "telefone_residencial")
	private String telefoneResidencial;
	
	@Column(name ="telefone_celular")
	private String telefoneCelular;
	
	@Column(name = "telefone_trabalho")
	private String telefoneTrabalho;
	
	//private String telefoneOutro;
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "responsavel")
	private boolean responsavel;
	
	@Column(name = "deletado")
	private boolean deletado;
	
	public Familiar(){
		this.deletado = false;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getTipoParentesco() {
		return tipoParentesco;
	}
	public void setTipoParentesco(String tipoParentesco) {
		this.tipoParentesco = tipoParentesco;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getRG() {
		return RG;
	}
	public void setRG(String rG) {
		RG = rG;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(String escolaridade) {
		this.escolaridade = escolaridade;
	}
	public Date getConculacaoEscolaridade() {
		return this.conclusaoEscolaridade;
	}
	public void setConculacaoEscolaridade(Date dataConculacaoEscolaridade) {
		this.conclusaoEscolaridade = dataConculacaoEscolaridade;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public Float getRenda() {
		return renda;
	}
	public void setRenda(Float renda) {
		this.renda = renda;
	}
	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}
	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}
	public Date getConclusaoEscolaridade() {
		return conclusaoEscolaridade;
	}

	public void setConclusaoEscolaridade(Date conclusaoEscolaridade) {
		this.conclusaoEscolaridade = conclusaoEscolaridade;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public String getTelefoneTrabalho() {
		return telefoneTrabalho;
	}
	public void setTelefoneTrabalho(String telefoneTrabalho) {
		this.telefoneTrabalho = telefoneTrabalho;
	}
//	public String getTelefoneOutro() {
//		return telefoneOutro;
//	}
//	public void setTelefoneOutro(String telefoneOutro) {
//		this.telefoneOutro = telefoneOutro;
//	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public boolean isResponsavel() {
		return responsavel;
	}
	public void setResponsavel(boolean responsavel) {
		this.responsavel = responsavel;
	}
	
	
}
