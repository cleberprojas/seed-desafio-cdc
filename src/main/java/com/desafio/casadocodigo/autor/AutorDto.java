package com.desafio.casadocodigo.autor;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class AutorDto implements Serializable{
	
	private static final long serialVersionUID = -8786917814703670926L;
	private Long id;
	
	@NotBlank(message = "Campo Nome, é Obrigatório")
	private String nome;
	
	@Email(message = "Formato do email é inválido")
	@NotBlank(message = "Campo Email, é Obrigatório")
	private String email;
	
	@NotBlank(message = "Campo Descrição, é Obrigatório")
	@Size(max = 400)
	private String descricao;
	
	public AutorDto(Autor dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.descricao = dto.getDescricao();
		this.email = dto.getEmail();			
	}

	public Autor toAutorObject() {
		return new Autor(this.nome, this.email, this.descricao, new Date());
	}

	@Override
	public String toString() {
		return "{id:" + id + ", nome:'" + nome + "', email:'" + email + "', descricao:'" + descricao + "'}";
	}
}
