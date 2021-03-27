package com.desafio.casadocodigo.api;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.casadocodigo.autor.AutorDto;
import com.desafio.casadocodigo.autor.AutorRepository;

@RestController
@RequestMapping("autor")
public class AutorController {
	
	@Autowired
	private AutorRepository autorRepository;
	
	@PostMapping
	@Transactional
	public ResponseEntity<AutorDto> save(@RequestBody @Valid AutorDto autorDto) {
		var createdAutor =  autorRepository.save(autorDto.toAutorObject());
		return ResponseEntity.ok().body(new AutorDto(createdAutor));
	}
	
	@GetMapping
	public List<AutorDto> find() {
		return autorRepository.findAll().stream().map(AutorDto::new).collect(Collectors.toList());
	}

}
