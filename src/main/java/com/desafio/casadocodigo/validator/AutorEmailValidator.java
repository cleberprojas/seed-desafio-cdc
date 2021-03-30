package com.desafio.casadocodigo.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.desafio.casadocodigo.autor.AutorDto;
import com.desafio.casadocodigo.autor.AutorRepository;

/***
 * 
 * use @UniqueValue 
 * */
@Component
@Deprecated
public class AutorEmailValidator implements Validator {
	
	@Autowired
	private AutorRepository autorRepo;

	@Override
	public boolean supports(Class<?> clazz) {
		return AutorDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors())
			return;
		AutorDto request = (AutorDto) target; 
		if(autorRepo.findByEmail(request.getEmail()).isPresent() ){
			errors.rejectValue("email", "1", "Email já Cadastrado!");
		}
	}
}
