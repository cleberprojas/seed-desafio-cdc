package com.desafio.casadocodigo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.casadocodigo.autor.AutorRepository;
import com.desafio.casadocodigo.categoria.CategoriaRepository;
import com.desafio.casadocodigo.livro.LivroDto;
import com.desafio.casadocodigo.livro.LivroRepository;

@Service
public class CadastraLivroService {
	
	@Autowired
	private AutorRepository autorRepo;
	
	@Autowired
	private CategoriaRepository categoriaRepo;
	
	@Autowired
	private LivroRepository livroRepo;
	
	public LivroDto cadastra(LivroDto livroDto) {
		var autor = autorRepo.findById(livroDto.getAutor().getId());
		var categoria = categoriaRepo.findById(livroDto.getCategoria().getId());
		var livro = livroDto.toLivroObject();
		autor.ifPresentOrElse(livro::setAutor, IllegalArgumentException::new);
		categoria.ifPresentOrElse(livro::setCategoria, IllegalArgumentException::new);
		return new LivroDto(livroRepo.save(livro));
	}

}
