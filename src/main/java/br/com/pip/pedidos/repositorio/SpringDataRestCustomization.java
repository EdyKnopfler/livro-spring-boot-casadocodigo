package br.com.pip.pedidos.repositorio;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import br.com.pip.pedidos.modelo.Cliente;
import br.com.pip.pedidos.modelo.Item;

// Expondo IDs na API gerada pelo Spring Data REST

@Configuration
public class SpringDataRestCustomization implements RepositoryRestConfigurer {
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config, cors);
		config.exposeIdsFor(Item.class, Cliente.class);
	}

}
