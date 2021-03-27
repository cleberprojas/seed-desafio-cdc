package com.desafio.casadocodigo.autor;

import java.time.Instant;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.lang.NonNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *	É necessário cadastrar um novo autor no sistema. 
 *  Todo autor tem um nome, email e uma descrição. 
 *  Também queremos saber o instante exato que ele foi registrado 
		-> O instante não pode ser nulo
		-> O email é obrigatório
		-> O email tem que ter formato válido
		-> O nome é obrigatório
		-> A descrição é obrigatória e não pode passar de 400 caracteres
 **/
@Entity
@Getter @Setter @NoArgsConstructor
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false)
	@NotBlank(message = "Campo Nome, é Obrigatório")
	private String nome;
	
	@Column
	@Email(message = "Formato do email é inválido")
	@NotBlank(message = "Campo Email, é Obrigatório")
	private String email;
	
	@Column(nullable=false, length=400)
	@NotBlank(message = "Campo Descrição, é Obrigatório")
	@Size(max = 400)
	private String descricao;
	
	@NonNull
	@Column
	private Date criadoEm;
	
	public Autor(String nome, String email, String descricao, Date criadoEm) {
		this.nome = nome;
		this.email =email;
		this.descricao = descricao;
		this.criadoEm = criadoEm;
	}

}
