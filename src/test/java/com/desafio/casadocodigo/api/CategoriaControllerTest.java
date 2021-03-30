package com.desafio.casadocodigo.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.desafio.casadocodigo.categoria.CategoriaDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class CategoriaControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldSaveCategoria() throws Exception {
		var uuid = UUID.randomUUID();
		CategoriaDto categoriaRequest = new CategoriaDto(null, uuid.toString());
		String content = new ObjectMapper().writeValueAsString(categoriaRequest);
		this.mockMvc.perform(post("/categorias")
							.content(content)
							.contentType(MediaType.APPLICATION_JSON)
						    .accept(MediaType.APPLICATION_JSON)
							)
		.andExpect(status().isOk() )
		.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	}
	
	@Test
	public void shouldNotSaveCategoria() throws Exception {
		CategoriaDto categoriaRequest = new CategoriaDto(null,"");
		String content = new ObjectMapper().writeValueAsString(categoriaRequest);
		this.mockMvc.perform(post("/categorias")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				)
		.andExpect(status().is4xxClientError() )
		.andExpect(MockMvcResultMatchers.jsonPath("$.id").doesNotExist());
	}
	
	@Test
	public void categoriaShouldBeUnique() throws Exception {
		CategoriaDto categoriaRequest = new CategoriaDto(null,"Ficcao");
		String content = new ObjectMapper().writeValueAsString(categoriaRequest);
		this.mockMvc.perform(post("/categorias")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				)
		.andExpect(status().is4xxClientError() )
		.andExpect( MockMvcResultMatchers.jsonPath("$.description").isNotEmpty());
	}
}