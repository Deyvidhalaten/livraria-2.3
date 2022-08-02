package br.com.senior.empresa.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Livraria")
@Table(name = "livraria")
public class Livraria implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_livraria")
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID codigo;

	@Column(length = 100, nullable = false)
	private String nome;

	@Column(nullable = false)
	private String email;

	@Column(nullable = false)
	private String numero_Telefone;

	@Column(nullable = false)
	private String cnpj;

	@OneToMany(mappedBy = "bookStore", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Livro> livros;

	public UUID getCodigo() {
		return codigo;
	}

	public void setCodigo(UUID codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumero_Telefone() {
		return numero_Telefone;
	}

	public void setNumero_Telefone(String numero_Telefone) {
		this.numero_Telefone = numero_Telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}