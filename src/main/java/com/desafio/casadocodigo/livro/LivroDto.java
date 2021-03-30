package com.desafio.casadocodigo.livro;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.desafio.casadocodigo.autor.AutorDto;
import com.desafio.casadocodigo.categoria.CategoriaDto;
import com.desafio.casadocodigo.validator.UniqueValue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class LivroDto{
	
	private Long id;
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message="Titulo deve ser único")
	private String titulo;
	
	@NotBlank
	@Size(max = 500)
	private String resumo;
	
	private String sumario;
	
	@Min(value = 20)
	private BigDecimal preco;
	
	private Integer numPaginas;
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn", message="ISBN deve ser único")
	private String isbn;
	
	@NotNull
	@Future(message = "Data de Lançamento precisa ser no futuro")
	private Date dataLancamento;
	
	@NotNull
	private CategoriaDto categoria;
	
	@NotNull
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

	@Override
	public String toString() {
		return "LivroDto [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", numPaginas=" + numPaginas + ", isbn=" + isbn + ", dataLancamento=" + dataLancamento
				+ ", categoria=" + categoria + ", autor=" + autor + "]";
	}
}
