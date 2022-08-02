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

import br.com.senior.empresa.dto.AutorDto;
import br.com.senior.empresa.mapper.AutorMapper;
import br.com.senior.empresa.model.entity.Autor;
import br.com.senior.empresa.model.sevice.AutorService;
import br.com.senior.empresa.repository.AutorRepository;

@RequestMapping(path = "/autor")
@RestController
public class AutorController {

	@Autowired
	private AutorRepository repository;

	@Autowired
	private AutorMapper mapper;

	@Autowired
	private AutorService service;

	@PostMapping(path = "/api/autor")
	public ResponseEntity<AutorDto> cadastrarEmpregado(@RequestBody AutorDto autorDto) {
		Autor autor = mapper.toEntity(autorDto);
		AutorDto body = mapper.toDto(service.createAutor(autor));
		return ResponseEntity.ok().body(body);
	}

	@PutMapping(path = "/api/atualizar/{codigo}")
	public ResponseEntity<AutorDto> atualizarAutor(@PathVariable String codigo, @RequestBody AutorDto autorDto) {

		UUID id = UUID.fromString(codigo);
		Autor autor = mapper.toEntity(autorDto);
		AutorDto body = mapper.toDto(service.updateAutor(id, autor));
		return ResponseEntity.ok().body(body);
	}

	@GetMapping(path = "/api/empregado/{codigo}")
	public ResponseEntity<AutorDto> findById(@PathVariable String codigo) {
		UUID id = UUID.fromString(codigo);

		AutorDto body = mapper.toDto(service.getAutor(id));
		return ResponseEntity.ok().body(body);

	}

//	@GetMapping(path = "/api/empregado/{codigo}")
//	public ResponseEntity<List<AutorDto>> findAll() {
//
//		List<AutorDto> empregadosDtos = service.getAllAutor().stream().map(e -> mapper.toDto(e))
//				.collect(Collectors.toList());
//
//		return ResponseEntity.ok().body(empregadosDtos);
//	}

	@DeleteMapping(path = "/api/deletarEmpregado/{codigo}")
	public ResponseEntity<String> delete(@PathVariable String codigo) {
		repository.deleteById(Integer.valueOf(codigo));
		return ResponseEntity.ok().body("Deletado");
	}
}
