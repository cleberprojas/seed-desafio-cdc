package com.desafio.casadocodigo.autor;

import java.io.Serializable;
import java.util.Date;

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
	private String nome;
	private String email;
	private String descricao;
	private Date criadoEm;
	
	public AutorDto(Autor dto) {
		this.id = dto.getId();
		this.nome = dto.getNome();
		this.descricao = dto.getDescricao();
		this.email = dto.getEmail();
		this.criadoEm = dto.getCriadoEm();		
	}

	public Autor toAutorObject() {
		return new Autor(this.nome, this.email, this.descricao, new Date());
	}

	@Override
	public String toString() {
		return "{id:" + id + ", nome:'" + nome + "', email:'" + email + "', descricao:'" + descricao + "', criadoEm:'"
				+ criadoEm.toString() + "'}";
	}
}
