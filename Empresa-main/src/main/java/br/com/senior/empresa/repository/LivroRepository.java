package br.com.senior.empresa.repository;

import br.com.senior.empresa.model.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

    @Transactional
    public Optional<Livro> findLivroByCodigo(UUID codigo);

    @Transactional
    boolean existsByCodigo(UUID codigo);

    @Transactional
    void deleteByCodigo(UUID codigo);
}
