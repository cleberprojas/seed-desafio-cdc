package com.desafio.casadocodigo.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nome;

}
