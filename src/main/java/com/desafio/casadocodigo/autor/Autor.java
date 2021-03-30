package com.desafio.casadocodigo.autor;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private String nome;
	
	@Column(unique = true)
	private String email;
	
	@Column(nullable=false, length=400)
	private String descricao;
	
	@Column(nullable=false)
	@NonNull
	private Date criadoEm;
	
	public Autor(String nome, String email, String descricao, Date criadoEm) {
		this.nome = nome;
		this.email =email;
		this.descricao = descricao;
		this.criadoEm = criadoEm;
	}

}
