package com.desafio.casadocodigo.pais;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.desafio.casadocodigo.base.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pais extends BaseEntity {
	
	@Column(nullable = false, unique = true)
	private String nome;

}
