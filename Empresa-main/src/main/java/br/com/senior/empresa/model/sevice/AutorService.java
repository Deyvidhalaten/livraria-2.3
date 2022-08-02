package br.com.senior.empresa.model.sevice;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senior.empresa.model.entity.Autor;
import br.com.senior.empresa.model.exception.AutorNotFoundException;
import br.com.senior.empresa.repository.AutorRepository;

@Service
public class AutorService {

	@Autowired
	private AutorRepository repository;

	public List<Autor> getAllAutor() {
		Optional<List<Autor>> autor = Optional.of(repository.findAll());

		if (autor.isPresent()) {
			return autor.get().stream().filter(Objects::nonNull).collect(Collectors.toList());

		}
		throw new AutorNotFoundException("Autor não encontrato");
	}

	public Autor getAutor(UUID codigo) {
		Optional<Autor> autor = repository.findAutorByCodigo(codigo);

		if (autor.isPresent()) {
			return autor.get();
		}
		throw new AutorNotFoundException("Empregado não encontrado");
	}

	public Autor createAutor(Autor autor) {
//		autor.setCodigo(UUID.randomUUID());
		return repository.save(autor);
	}

	public Autor updateAutor(UUID codigo, Autor autor) {
		Autor oldAutor = this.getAutor(codigo);
		oldAutor.setNome(autor.getNome());
		oldAutor.setLivro(autor.getLivro());

		return this.createAutor(oldAutor);
	}

	public void deleteAutor(UUID codigo) {
		if (!repository.existsByCodigo(codigo)) {
			throw new AutorNotFoundException("Empregado não encontrado");
		}
		repository.deleteByCodigo(codigo);
	}

}
