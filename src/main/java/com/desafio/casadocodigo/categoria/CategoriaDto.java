package com.desafio.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import com.desafio.casadocodigo.base.Validatable;
import com.desafio.casadocodigo.validator.UniqueValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CategoriaDto implements Validatable{
	
	private Long id;
	
	@NotBlank(message = "nome não pode ser vazio")
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome",message = "Esse nome já está em uso")
	private String nome;
	
	public Categoria toCategoriaObject(){
		return new Categoria(this.nome);
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
