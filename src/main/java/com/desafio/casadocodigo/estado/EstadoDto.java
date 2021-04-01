package com.desafio.casadocodigo.estado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.desafio.casadocodigo.base.BaseDto;
import com.desafio.casadocodigo.pais.Pais;
import com.desafio.casadocodigo.pais.PaisDto;
import com.desafio.casadocodigo.validator.MustExist;
import com.desafio.casadocodigo.validator.UniqueValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
public class EstadoDto extends BaseDto{
	
	
	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;
	
	@NotNull
	@MustExist(domainClass = Pais.class)
	private PaisDto pais;
	
	public EstadoDto(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.pais = new PaisDto(estado.getPais());
	}
	
	public Estado toEstadoObject() {
		return new Estado(this.getNome(), this.pais.toPaisObject());
	}
	
	@Override
	public String toString() {
		return "EstadoDto [id=" + id + ", nome=" + nome + ", pais=" + pais + "]";
	}
}