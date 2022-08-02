package br.com.senior.empresa.model.sevice;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senior.empresa.model.entity.Livraria;
import br.com.senior.empresa.model.exception.LivrariaNotFoundException;
import br.com.senior.empresa.repository.LivrariaRepository;

@Service
public class LivrariaService {

	@Autowired
	private LivrariaRepository repository;

	public List<Livraria> getAlllivrarias() {
		Optional<List<Livraria>> livrarias = Optional.of(repository.findAll());

		if (livrarias.isPresent()) {
			return livrarias.get().stream().filter(Objects::nonNull).collect(Collectors.toList());
		}
		throw new LivrariaNotFoundException("Livraria não encontrada");
	}

	public Livraria getLivraria(UUID id) {
		Optional<Livraria> livraria = repository.findLivrariaByCodigo(id);

		if (livraria.isPresent()) {
			return livraria.get();
		}
		throw new LivrariaNotFoundException("Empregado não encontrado");
	}

	public Livraria createLivraria(Livraria livraria) {
//		livraria.setCodigo(UUID.randomUUID());
		return repository.save(livraria);
	}

	public Livraria updateLivraria(UUID id, Livraria livraria) {
		Livraria oldLivraria = this.getLivraria(id);
		oldLivraria.setNome(livraria.getNome());
		oldLivraria.setEmail(livraria.getEmail());
		oldLivraria.setNumero_Telefone(livraria.getNumero_Telefone());
		oldLivraria.setCnpj(livraria.getCnpj());
		oldLivraria.setLivros(livraria.getLivros());

		return this.createLivraria(oldLivraria);
	}

	public void deleteLivraria(UUID id) {
		if (!repository.existsByCodigo(id)) {
			throw new LivrariaNotFoundException("Empregado não encontrado");
		}
		repository.deleteByCodigo(id);
	}

}
