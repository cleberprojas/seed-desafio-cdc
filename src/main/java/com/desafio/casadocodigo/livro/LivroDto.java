package com.desafio.casadocodigo.livro;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.desafio.casadocodigo.autor.Autor;
import com.desafio.casadocodigo.autor.AutorDto;
import com.desafio.casadocodigo.base.BaseDto;
import com.desafio.casadocodigo.categoria.Categoria;
import com.desafio.casadocodigo.categoria.CategoriaDto;
import com.desafio.casadocodigo.validator.MustExist;
import com.desafio.casadocodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivroDto extends BaseDto{
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message="Titulo deve ser único")
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	@JsonInclude(Include.NON_NULL)
	private String resumo;
	
	@JsonInclude(Include.NON_NULL)
	private String sumario;
	
	@Min(value = 20)
	@JsonInclude(Include.NON_NULL)
	private BigDecimal preco;
	
	@JsonInclude(Include.NON_NULL)
	private Integer numPaginas;
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn", message="ISBN deve ser único")
	@JsonInclude(Include.NON_NULL)
	private String isbn;
	
	@NotNull
	@Future(message = "Data de Lançamento precisa ser no futuro")
	@JsonInclude(Include.NON_NULL)
	private Date dataLancamento;
	
	@NotNull
	@JsonInclude(Include.NON_NULL)
	@MustExist(domainClass = Categoria.class)
	private CategoriaDto categoria;
	
	@NotNull
	@JsonInclude(Include.NON_NULL)
	@MustExist(domainClass = Autor.class)
	private AutorDto autor;
	
	public Livro toLivroObject() {
		return new Livro(titulo, resumo, sumario, preco, numPaginas, isbn, dataLancamento, categoria.toCategoriaObject(), autor.toAutorObject());
	}
	
	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
		this.autor = new AutorDto(livro.getAutor());
		this.categoria = new CategoriaDto(livro.getCategoria());
		this.dataLancamento = livro.getDataLancamento();
		this.isbn = livro.getIsbn();
		this.numPaginas = livro.getNumPaginas();
		this.preco = livro.getPreco();
		this.resumo = livro.getResumo();
		this.sumario = livro.getSumario();
		this.titulo = livro.getTitulo();		
	}
	
	public LivroDto withId(Long id) {
		this.id = id;
		return this;	
	}
	
	public LivroDto withTitulo(String titulo) {
		this.titulo = titulo;
		return this;	
	}

	@Override
	public String toString() {
		return "LivroDto [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", numPaginas=" + numPaginas + ", isbn=" + isbn + ", dataLancamento=" + dataLancamento
				+ ", categoria=" + categoria + ", autor=" + autor + "]";
	}
}
