package br.gov.sc.geracaotec.educandario.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "alunos")
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name = "sexo")
	private Character sexo;

	
	@CollectionTable(name = "alunos_necessidades_especiais")
	@ElementCollection(targetClass=String.class)
	private List<String> necessidadesEspeciais;
	
	@Column(name = "documentos_necessarios")
	private String documentoNecessarios; //
	
	@Column(name = "avaliacao")
	private String avaliacao;
	
	@Column(name = "condicao_familiar")
	private String condicaoFamiliar;
	
	@Column(name = "tipo_moradia")
	private String tipoMoradia; //Implementado - Verificar o Banco
	
	@Column(name = "informacao_moradia")
	private String informacaoMoradia;
	
	@Column(name = "CEP")
	private String CEP;
	
	@Column(name = "endereco")
	private String endereco
	;
	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "cidade")
	private String cidade;
	
	@OneToMany @JoinTable (name = "familhares_alunos")
	private List<Familiar> familiares; 
	
	@Column(name = "bolasa_familia")// Verificar ação
	private boolean bolsaFamilia;
	
	@Column(name = "numero_NIS") 
	private String numeroNIS;
	
	@Column(name = "deletado")
	private boolean deletado;
	
	
	

	// Composição familar --- Lista dos familiares ou moradores da mesma casa...
	// situação da Habitação ---- tipo de moradia ---- propria sedida ou aludada
	// --> (Valor)
	// Bolsa familia se tiver adicionar Nºdo do NIS (cadastro unico) ->
	// misnisterio do desenolvimento social

	public Aluno() {
		this.familiares = new ArrayList<Familiar>();
		this.deletado = false;		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Character getSexo() {
		return sexo;
	}

	public void setSexo(Character sexo) {
		this.sexo = sexo;
	}

	public List<String> getNecessidadesEspeciais() {
		return necessidadesEspeciais;
	}

	public void setNecessidadesEspeciais(
			List<String> necessidadesEspeciais) {
		this.necessidadesEspeciais = necessidadesEspeciais;
	}

	public String getDocumentoNecessarios() {
		return documentoNecessarios;
	}

	public void setDocumentoNecessarios(String documentoNecessarios) {
		this.documentoNecessarios = documentoNecessarios;
	}

	public String getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(String avaliacao) {
		this.avaliacao = avaliacao;
	}

	public String getCondicaoFamiliar() {
		return condicaoFamiliar;
	}

	public void setCondicaoFamiliar(String condicaoFamiliar) {
		this.condicaoFamiliar = condicaoFamiliar;
	}

	public String getInformacaoMoradia() {
		return informacaoMoradia;
	}

	public void setInformacaoMoradia(String informacaoMoradia) {
		this.informacaoMoradia = informacaoMoradia;
	}

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

	public List<Familiar> getFamiliares() {
		return familiares;
	}

	public void setFamiliares(List<Familiar> familiares) {
		this.familiares = familiares;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String cEP) {
		CEP = cEP;
	}

	public String getTipoMoradia() {
		return tipoMoradia;
	}

	public void setTipoMoradia(String tipoMoradia) {
		this.tipoMoradia = tipoMoradia;
	}

	public boolean isBolsaFamilia() {
		return bolsaFamilia;
	}

	public void setBolsaFamilia(boolean bolsaFamilia) {
		this.bolsaFamilia = bolsaFamilia;
	}

	public String getNumeroNIS() {
		return numeroNIS;
	}

	public void setNumeroNIS(String numeroNIS) {
		this.numeroNIS = numeroNIS;
	}

	public boolean isDeletado() {
		return deletado;
	}

	public void setDeletado(boolean deletado) {
		this.deletado = deletado;
	}

	
}
