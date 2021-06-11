package br.com.pip.pedidos;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.pip.pedidos.modelo.Cliente;
import br.com.pip.pedidos.repositorio.ClienteRepository;

@SpringBootTest
@ActiveProfiles("test")
public class ClienteRepositoryTest {
	
	@Autowired
	private ClienteRepository repositorio;
	
	@Test
	public void buscaClientesCadastrados() {
		List<Cliente> clientes = repositorio.findAll();
		assertThat(clientes.size(), is(2));
		assertThat(clientes.get(0).getNome(), startsWith("Cornélio"));
	}	
	
}
