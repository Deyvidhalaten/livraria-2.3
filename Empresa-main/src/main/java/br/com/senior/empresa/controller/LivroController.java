package br.com.senior.empresa.controller;


import br.com.senior.empresa.dto.LivroDto;
import br.com.senior.empresa.mapper.LivroMapper;
import br.com.senior.empresa.model.entity.Livro;
import br.com.senior.empresa.model.sevice.LivroService;
import br.com.senior.empresa.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/livro")
public class LivroController {

    @Autowired
    private LivroRepository repository;

    @Autowired
    private LivroService service;

    @Autowired
    private LivroMapper mapper;

    @PostMapping(path = "/api/livro/")
    public ResponseEntity<LivroDto> cadastrarLivro(@RequestBody LivroDto livroDto){

        Livro livro = mapper.toEntity(livroDto);
        livro.setCodigo(UUID.randomUUID());
        LivroDto body = mapper.toDto(service.createLivro(livro));
        return ResponseEntity.ok().body(body);
    }

    @PutMapping(path = "/api/atualizar/{codigo}")
    public ResponseEntity<LivroDto> atualizarEmpregado(@PathVariable String codigo, @RequestBody LivroDto livroDto) {

        UUID id = UUID.fromString(codigo);
        Livro livro = mapper.toEntity(livroDto);
        LivroDto body = mapper.toDto(service.updateLivro(id, livro));
        return ResponseEntity.ok().body(body);
    }

    @GetMapping(path = "/api/livro/{codigo}")
    public ResponseEntity<LivroDto> findById(@PathVariable String codigo){
        UUID id = UUID.fromString(codigo);

        LivroDto body = mapper.toDto(service.getLivro(id));
        return ResponseEntity.ok().body(body);

    }

    @DeleteMapping(path = "/api/deletarLivro/{codigo}")
    public ResponseEntity<String> delete(@PathVariable String codigo){
        repository.deleteById(Integer.valueOf(codigo));
        return ResponseEntity.ok().body("Deletado");
    }


}
