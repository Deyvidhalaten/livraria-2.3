package br.com.senior.empresa.mapper;

import org.springframework.stereotype.Service;

import br.com.senior.empresa.dto.LivroDto;
import br.com.senior.empresa.model.entity.Livro;

@Service
public class LivroMapper {

	public LivroDto toDto(Livro livro) {
		LivroDto dto = new LivroDto();
		dto.descricao = livro.getDescricao();
		dto.titulo = livro.getTitulo();
		dto.bookStore = livro.getBookStore();
		dto.dataLancamento = livro.getDataLancamento();
		dto.autor = livro.getAutor();
		dto.preco = livro.getPreco();

		return dto;
	}

	public Livro toEntity(LivroDto dto) {
		Livro livro = new Livro();

		livro.setTitulo(dto.titulo);
		livro.setDescricao(dto.descricao);
		livro.setPreco(dto.preco);
		livro.setDataLancamento(dto.dataLancamento);
		livro.setBookStore(dto.bookStore);
		livro.setAutor(dto.autor);

		return livro;
	}
}
