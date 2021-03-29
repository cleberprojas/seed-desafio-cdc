package com.desafio.casadocodigo.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.desafio.casadocodigo.autor.AutorDto;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class AutorControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void shouldSaveAutor() throws Exception {
		AutorDto autor = new AutorDto(null,"Cleber Teste", "cleber@email.com","livro teste");
		String content = new ObjectMapper().writeValueAsString(autor);
		this.mockMvc.perform(post("/autor")
							.content(content)
							.contentType(MediaType.APPLICATION_JSON)
						    .accept(MediaType.APPLICATION_JSON)
							)
		.andExpect(status().isOk() )
		.andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
	}
	
	@Test
	public void shouldNotSaveAutor() throws Exception {
		AutorDto autor = new AutorDto(null,"", "cleber@email.com","livro teste");
		String content = new ObjectMapper().writeValueAsString(autor);
		this.mockMvc.perform(post("/autor")
				.content(content)
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				)
		.andExpect(status().is4xxClientError() )
		.andExpect(MockMvcResultMatchers.jsonPath("$.id").doesNotExist());
	}
	
	 


}
