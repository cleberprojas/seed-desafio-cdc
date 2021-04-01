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

import com.desafio.casadocodigo.estado.EstadoDto;
import com.desafio.casadocodigo.pais.Pais;

@RestController
@RequestMapping("estados")
public class EstadoController {
	@Autowired
	private EntityManager em;
	
	@PostMapping
	@Transactional
	public ResponseEntity<EstadoDto> save(@RequestBody @Valid EstadoDto estadoDto) {
		var estado = estadoDto.toEstadoObject();
		estado.setPais(em.find(Pais.class,estadoDto.getPais().getId()));
		em.persist(estado);
		return ResponseEntity.ok(new EstadoDto(estado));
	}
}
