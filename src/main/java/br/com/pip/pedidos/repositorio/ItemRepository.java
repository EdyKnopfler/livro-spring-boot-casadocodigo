package br.com.pip.pedidos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.pip.pedidos.modelo.Item;

// Expondo o repositório como API REST

@RepositoryRestResource(collectionResourceRel = "itens", path = "itens")
public interface ItemRepository extends JpaRepository<Item, Long> {

}
