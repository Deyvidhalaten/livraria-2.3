package br.com.senior.empresa.model.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Autor")
@Table(name = "autor")
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_autor")
	@NotNull
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID codigo;

	@Column(length = 100, nullable = false)
	private String nome;

	@ManyToMany(mappedBy = "autor")
	@JsonIgnore
	private List<Livro> livro;

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

	public List<Livro> getLivro() {
		return livro;
	}

	public void setLivro(List<Livro> livro) {
		this.livro = livro;
	}
}
