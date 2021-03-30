package com.desafio.casadocodigo.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.desafio.casadocodigo.base.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*** 
 
 -> Toda categoria precisa de um nome
 
 -> O nome é obrigatório
 -> O nome não pode ser duplicado
 * 
 * @author cleber.rojas
 *
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Categoria extends BaseEntity{
	
	@Column(unique = true)
	private String nome;

}
