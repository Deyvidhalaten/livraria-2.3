package br.com.senior.empresa.mapper;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import br.com.senior.empresa.dto.LivrariaDto;
import br.com.senior.empresa.model.entity.Livraria;

@Service
public class LivrariaMapper {

	public LivrariaDto toDto(Livraria livraria) {
		LivrariaDto dto = new LivrariaDto();

		dto.nome = livraria.getNome();
		dto.email = livraria.getEmail();
		dto.numero_Telefone = livraria.getNumero_Telefone();
		dto.livros = livraria.getLivros();
		dto.cnpj = livraria.getCnpj();

		return dto;
	}

	public Livraria toEntity(@NotNull LivrariaDto dto) {
		Livraria livraria = new Livraria();

		livraria.setNome(dto.nome);
		livraria.setEmail(dto.email);
		livraria.setNumero_Telefone(dto.numero_Telefone);
		livraria.setCnpj(dto.cnpj);
		livraria.setLivros(dto.livros);

		return livraria;
	}
}
