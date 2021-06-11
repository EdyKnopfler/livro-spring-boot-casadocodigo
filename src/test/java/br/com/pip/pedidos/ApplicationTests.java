package br.com.pip.pedidos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void home() throws Exception {
		mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Clientes")));
	}
	
	@Test
	public void api() throws Exception {
		mockMvc.perform(get("/api/clientes"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$._embedded.clientes", hasSize(2)));
	}
	
	@Test
	public void pedido() throws Exception {
		mockMvc.perform(
						post("/rest/pedidos")
								.contentType(MediaType.APPLICATION_JSON)
								.content("{\"clienteId\": 1, \"itemIds\": [1, 2]}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.valorTotal", is(70.0)));
	}

}
