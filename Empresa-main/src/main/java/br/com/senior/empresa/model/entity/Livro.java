package br.com.senior.empresa.model.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Livro")
@Table(name = "livro")
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_livro")
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID codigo;

	@Column(nullable = false)
	private String titulo;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private String preco;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	private List<Autor> autor;

	@Column(nullable = false)
	private LocalDate dataLancamento;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "livraria", referencedColumnName = "id_livraria")
	private Livraria bookStore;

	public UUID getCodigo() {
		return codigo;
	}

	public void setCodigo(UUID codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public List<Autor> getAutor() {
		return autor;
	}

	public void setAutor(List<Autor> autor) {
		this.autor = autor;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Livraria getBookStore() {
		return bookStore;
	}

	public void setBookStore(Livraria bookStore) {
		this.bookStore = bookStore;
	}

}
