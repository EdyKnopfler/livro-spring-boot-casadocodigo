package br.com.pip.pedidos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pip.pedidos.modelo.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
