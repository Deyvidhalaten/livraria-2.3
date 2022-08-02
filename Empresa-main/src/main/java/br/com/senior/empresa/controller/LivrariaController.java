package br.com.senior.empresa.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senior.empresa.dto.LivrariaDto;
import br.com.senior.empresa.mapper.LivrariaMapper;
import br.com.senior.empresa.model.entity.Livraria;
import br.com.senior.empresa.model.sevice.LivrariaService;
import br.com.senior.empresa.repository.LivrariaRepository;

@RestController
@RequestMapping(path = "/livraria")
public class LivrariaController {

	@Autowired
	private LivrariaRepository repository;

	@Autowired
	private LivrariaService service;

	@Autowired
	private LivrariaMapper mapper;

	@PostMapping(path = "/api/livraria")
	public ResponseEntity<LivrariaDto> cadastrarEmpregado(@RequestBody LivrariaDto livrariaDto) {

		Livraria livraria = mapper.toEntity(livrariaDto);
		livraria.setCodigo(UUID.randomUUID());
		LivrariaDto body = mapper.toDto(service.createLivraria(livraria));
		return ResponseEntity.ok().body(body);
	}

	@PutMapping(path = "/api/atualizar/{codigo}")
	public ResponseEntity<LivrariaDto> atualizarEmpregado(@PathVariable String codigo,
			@RequestBody LivrariaDto livrariaDto) {

		UUID id = UUID.fromString(codigo);
		Livraria livraria = mapper.toEntity(livrariaDto);
		LivrariaDto body = mapper.toDto(service.updateLivraria(id, livraria));
		return ResponseEntity.ok().body(body);
	}

	@GetMapping(path = "/api/livraria/{codigo}")
	public ResponseEntity<LivrariaDto> findById(@PathVariable String codigo) {
		UUID id = UUID.fromString(codigo);

		LivrariaDto body = mapper.toDto(service.getLivraria(id));
		return ResponseEntity.ok().body(body);

	}

//    @GetMapping(path = "/api/livraria")
//    public ResponseEntity<List<LivrariaDto>> findAll(){
//
//        List<LivrariaDto> livrariaDtos = service.getAlllivrarias().stream().map(e -> mapper.toDto(e)).collect(Collectors.toList());
//
//        return ResponseEntity.ok().body(livrariaDtos);
//    }

	@DeleteMapping(path = "/api/deletarLivraria/{codigo}")
	public ResponseEntity<String> delete(@PathVariable String codigo) {
		repository.deleteById(Integer.valueOf(codigo));
		return ResponseEntity.ok().body("Deletado");
	}
}
