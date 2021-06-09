package br.com.pip.pedidos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pip.pedidos.modelo.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
