package com.desafio.casadocodigo.livro;

import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.desafio.casadocodigo.autor.Autor;
import com.desafio.casadocodigo.base.BaseEntity;
import com.desafio.casadocodigo.categoria.Categoria;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Livro extends BaseEntity{
	
	@Column(nullable=false, unique = true)
	private String titulo;
	
	@Column(nullable=false,length = 500)
	private String resumo;
	
	private String sumario;
	
	@Column(nullable=false)
	private BigDecimal preco;
	
	@Column(nullable=false)
	private Integer numPaginas;
	
	@Column(nullable=false, unique = true)
	private String isbn;
	
	private Date dataLancamento;
	
	@OneToOne(cascade = ALL)
	@JoinColumn(name="categoria_id", nullable = false)
	private Categoria categoria;
	
	@ManyToOne(cascade = ALL)
    @JoinColumn(name="autor_id", nullable = false)
	private Autor autor;

}
