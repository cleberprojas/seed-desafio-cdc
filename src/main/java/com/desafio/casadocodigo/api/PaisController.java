package com.desafio.casadocodigo.api;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.casadocodigo.pais.PaisDto;

@RestController
@RequestMapping("paises")
public class PaisController {

	@Autowired
	private EntityManager em;
	
	@PostMapping
	@Transactional
	public ResponseEntity<PaisDto> save(@RequestBody @Valid PaisDto paisDto) {
		var pais = paisDto.toPaisObject();
		em.persist(pais);
		return ResponseEntity.ok(new PaisDto(pais));
	}
}
