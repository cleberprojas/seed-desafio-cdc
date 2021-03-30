package com.desafio.casadocodigo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.desafio.casadocodigo.categoria.CategoriaDto;
import com.desafio.casadocodigo.categoria.CategoriaRepository;

/***
 * 
 * use @UniqueValue 
 * */
@Component
@Deprecated
public class CategoriaNomeValidator implements Validator {
	
	@Autowired
	private CategoriaRepository repo;

	@Override
	public boolean supports(Class<?> clazz) {
		return CategoriaDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors())
			return;
		CategoriaDto request = (CategoriaDto) target; 
		if(repo.findByNome(request.getNome()).isPresent() ){
			errors.rejectValue("nome", "2", "Nome da Categoria já Cadastrado!");
		}
	}
}
