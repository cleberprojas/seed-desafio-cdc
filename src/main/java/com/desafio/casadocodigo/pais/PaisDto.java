package com.desafio.casadocodigo.pais;

import javax.validation.constraints.NotBlank;

import com.desafio.casadocodigo.base.BaseDto;
import com.desafio.casadocodigo.validator.UniqueValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class PaisDto extends BaseDto {
	
	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	public PaisDto(Pais pais) {
		this.id = pais.getId();
		this.nome = pais.getNome();
	}
	
	@Override
	public String toString() {
		return "PaisDto [id=" + id + ", nome=" + nome + "]";
	}

	public Pais toPaisObject() {
		return new Pais(this.nome);
	}
}