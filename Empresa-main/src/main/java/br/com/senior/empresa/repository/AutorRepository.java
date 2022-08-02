package br.com.senior.empresa.repository;

import br.com.senior.empresa.model.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {

    @Transactional
    Optional<Autor> findAutorByCodigo(UUID id);

    @Transactional
    boolean existsByCodigo(UUID id);

    @Transactional
    void deleteByCodigo(UUID id);

}
