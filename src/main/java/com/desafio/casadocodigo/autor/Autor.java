package com.desafio.casadocodigo.autor;

import java.util.Date;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.lang.NonNull;

import com.desafio.casadocodigo.base.BaseEntity;
import com.desafio.casadocodigo.livro.Livro;

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
public class Autor extends BaseEntity{
	
	@Column(nullable=false)
	private String nome;
	
	@Column(unique = true)
	private String email;
	
	@Column(nullable=false, length=400)
	private String descricao;
	
	@Column(nullable=false)
	@NonNull
	private Date criadoEm;
	
	@OneToMany(cascade=ALL, mappedBy="autor")
    private List<Livro> livros;

	
	public Autor(String nome, String email, String descricao, Date criadoEm) {
		this.nome = nome;
		this.email =email;
		this.descricao = descricao;
		this.criadoEm = criadoEm;
	}

}
