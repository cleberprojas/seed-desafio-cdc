package com.desafio.casadocodigo.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.casadocodigo.livro.Livro;
import com.desafio.casadocodigo.livro.LivroDao;
import com.desafio.casadocodigo.livro.LivroDto;

@RestController
@RequestMapping("livros")
public class LivroController {
	
	@Autowired
	private LivroDao livroDao;//1
	
	@PostMapping
	@Transactional 
	//1
	public ResponseEntity<LivroDto> save(@RequestBody @Valid LivroDto livroDto) {
		return ResponseEntity.ok(new LivroDto(livroDao.save(livroDto)));
	}
	
	@GetMapping
	//1
	public List<LivroDto> findAll() {
		List<Livro> livros = livroDao.findAll();
		return livros.stream()//1
				.map(livro -> new LivroDto().withId(livro.getId()).withTitulo(livro.getTitulo()))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{id}")
	//1
	public ResponseEntity<LivroDto> find(@PathVariable Long id) {
		var hasLivro = livroDao.findById(id);
		if(hasLivro.isPresent()) {//1
			LivroDto response =   new LivroDto(hasLivro.get());
			return ResponseEntity.ok(response); 
		}
		return ResponseEntity.notFound().build();
	}
				

}
