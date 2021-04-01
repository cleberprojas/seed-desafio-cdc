package com.desafio.casadocodigo.livro;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.desafio.casadocodigo.autor.Autor;
import com.desafio.casadocodigo.categoria.Categoria;

@Component
public class LivroDao {

	@Autowired
	private EntityManager em;

	// 1
	@Transactional
	public Livro save(LivroDto livroDto) {
		var autor = em.find(Autor.class, livroDto.getAutor().getId());// 1
		var categoria = em.find(Categoria.class, livroDto.getCategoria().getId());// 1
		var livro = livroDto.toLivroObject();// 1
		livro.setAutor(autor);
		livro.setCategoria(categoria);
		em.persist(livro);
		return livro;
	}

	// 1
	public List<Livro> findAll() {
		return em.createQuery("from Livro").getResultList();
	}

	// 1
	public Optional<Livro> findById(Long id) {
		return Optional.ofNullable(em.find(Livro.class, id));
	}
}