package com.desafio.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CategoriaDto {
	
	private Long id;
	
	@NotBlank(message = "nome não pode ser vazio")
	private String nome;
	
	public Categoria toCategoriaObject(){
		return new Categoria(this.id, this.nome);
	}
	
	public CategoriaDto(Categoria categoria) {
		 this.id = categoria.getId();
		 this.nome = categoria.getNome();
	}

	@Override
	public String toString() {
		return "CategoriaDto [id=" + id + ", nome=" + nome + "]";
	}

}
