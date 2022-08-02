package br.com.senior.empresa.dto;

import java.time.LocalDate;
import java.util.List;

import br.com.senior.empresa.model.entity.Autor;
import br.com.senior.empresa.model.entity.Livraria;

public class LivroDto {

	public String titulo;

	public String descricao;

	public String preco;

	public LocalDate dataLancamento;

	public Livraria bookStore;

	public List<Autor> autor;
}
