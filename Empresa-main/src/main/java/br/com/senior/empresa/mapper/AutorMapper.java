package br.com.senior.empresa.mapper;

import br.com.senior.empresa.dto.AutorDto;
import br.com.senior.empresa.model.entity.Autor;
import org.springframework.stereotype.Service;

@Service
public class AutorMapper {

    public AutorDto toDto (Autor autor){
        AutorDto dto = new AutorDto();
        dto.livro = autor.getLivro();
        dto.nome = autor.getNome();

        return dto;
    }

    public Autor toEntity(AutorDto dto){
        Autor autor = new Autor();

        autor.setLivro(dto.livro);
        autor.setNome(dto.nome);

        return autor;
    }
}
