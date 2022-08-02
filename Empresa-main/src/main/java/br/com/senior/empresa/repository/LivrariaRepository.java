package br.com.senior.empresa.repository;
import br.com.senior.empresa.model.entity.Livraria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LivrariaRepository extends JpaRepository<Livraria, Integer> {

    @Transactional
    Optional<Livraria> findLivrariaByCodigo(UUID id);

    @Transactional
    boolean existsByCodigo(UUID id);

    @Transactional
    void deleteByCodigo(UUID id);

}

