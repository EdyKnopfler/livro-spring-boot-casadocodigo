package br.com.pip.pedidos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.pip.pedidos.modelo.Pedido;

@RepositoryRestResource(collectionResourceRel = "pedidos", path = "pedidos")
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
