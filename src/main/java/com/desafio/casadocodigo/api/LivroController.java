package com.desafio.casadocodigo.api;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.casadocodigo.livro.LivroDto;
import com.desafio.casadocodigo.service.CadastraLivroService;

@RestController
@RequestMapping("livros")
public class LivroController {
	
	@Autowired
	private CadastraLivroService service;
	
	@PostMapping
	@Transactional
	public ResponseEntity<LivroDto> save(@RequestBody @Valid LivroDto livroDto) {
		return ResponseEntity.ok(service.cadastra(livroDto));
	}

}
