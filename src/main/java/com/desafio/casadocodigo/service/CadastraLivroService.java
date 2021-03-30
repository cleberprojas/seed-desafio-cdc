package com.desafio.casadocodigo.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.desafio.casadocodigo.autor.Autor;
import com.desafio.casadocodigo.categoria.Categoria;
import com.desafio.casadocodigo.livro.LivroDto;

@Service
public class CadastraLivroService {
	
	@PersistenceContext
	private EntityManager entityManager;//1
	
	//1
	public LivroDto cadastra(LivroDto livroDto) {
		var autor = entityManager.find(Autor.class, livroDto.getAutor().getId());//1
		var categoria = entityManager.find(Categoria.class, livroDto.getCategoria().getId());//1
		var livro = livroDto.toLivroObject();
		livro.setAutor(autor);
		livro.setCategoria(categoria);
		entityManager.persist(livro);//1
		return new LivroDto(livro);
	}

}
