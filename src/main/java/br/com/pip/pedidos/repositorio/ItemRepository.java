package br.com.pip.pedidos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pip.pedidos.modelo.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
