package com.desafio.casadocodigo.api;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.casadocodigo.categoria.CategoriaDto;
import com.desafio.casadocodigo.categoria.CategoriaRepository;
import com.desafio.casadocodigo.validator.CategoriaNomeValidator;

@RestController
@RequestMapping("categorias")
public class CategoriaController {
	
	@Autowired
	private CategoriaNomeValidator categoriaNomeValidator;
	
	@Autowired
	private CategoriaRepository repo;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(categoriaNomeValidator);
	}
	
	@PostMapping
	public CategoriaDto save(@RequestBody @Valid CategoriaDto categoriaDto) {
		return new CategoriaDto(repo.save(categoriaDto.toCategoriaObject()));
	}

}
