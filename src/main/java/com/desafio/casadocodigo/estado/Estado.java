package com.desafio.casadocodigo.estado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.desafio.casadocodigo.base.BaseEntity;
import com.desafio.casadocodigo.pais.Pais;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Estado extends BaseEntity {

	@Column(nullable = false, unique = true)
	private String nome;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "pais_id")
	private Pais pais;
}
