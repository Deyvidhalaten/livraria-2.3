package br.com.senior.empresa.model.sevice;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senior.empresa.model.entity.Livro;
import br.com.senior.empresa.model.exception.LivroNotFoundException;
import br.com.senior.empresa.repository.LivroRepository;

@Service
public class LivroService {
	@Autowired
	private LivroRepository repository;

	public List<Livro> getAllLivros() {
		Optional<List<Livro>> livro = Optional.of(repository.findAll());

		if (livro.isPresent()) {
			return livro.get().stream().filter(Objects::nonNull).collect(Collectors.toList());
		}
		throw new LivroNotFoundException("Empregados não encontrado");
	}

	public Livro getLivro(UUID id) {
		Optional<Livro> livro = repository.findLivroByCodigo(id);

		if (livro.isPresent()) {
			return livro.get();
		}
		throw new LivroNotFoundException("Empregado não encontrado");
	}

	public Livro createLivro(Livro livro) {
//		livro.setCodigo(UUID.randomUUID());
		return repository.save(livro);
	}

	public Livro updateLivro(UUID codigo, Livro livro) {
		Livro oldLivro = this.getLivro(codigo);
		oldLivro.setTitulo(livro.getTitulo());
		oldLivro.setDescricao(livro.getDescricao());
		oldLivro.setPreco(livro.getPreco());
		oldLivro.setBookStore(livro.getBookStore());
		oldLivro.setAutor(livro.getAutor());

		return this.createLivro(oldLivro);
	}

	public void deleteLivro(UUID id) {
		if (!repository.existsByCodigo(id)) {
			throw new LivroNotFoundException("Livro não encontrado");
		}
		repository.deleteByCodigo(id);
	}

}
