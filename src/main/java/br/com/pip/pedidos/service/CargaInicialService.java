package br.com.pip.pedidos.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.pip.pedidos.modelo.Cliente;
import br.com.pip.pedidos.modelo.Item;
import br.com.pip.pedidos.modelo.Pedido;
import br.com.pip.pedidos.repositorio.ClienteRepository;
import br.com.pip.pedidos.repositorio.ItemRepository;
import br.com.pip.pedidos.repositorio.PedidoRepository;

@Service
public class CargaInicialService {
	
	@Autowired
	private ClienteRepository clientes;
	
	@Autowired
	private ItemRepository itens;
	
	@Autowired
	private PedidoRepository pedidos;
	
	@Transactional
	public void realizarCarga() {
		Cliente kania = new Cliente("Scania", "Rua dos Gatos");
		Cliente tomzim = new Cliente("Tom", "Rua dos Gatos");
		
		clientes.save(kania);
		clientes.save(tomzim);
		
		Item potim = new Item("Comedouro", new BigDecimal(25.00));
		Item saxe = new Item("Sachê", new BigDecimal(2.50));
		Item comidaQueElesNaoGosta = new Item("Ração Premium", new BigDecimal(60.00));
		
		itens.save(potim);
		itens.save(saxe);
		itens.save(comidaQueElesNaoGosta);
		
		Pedido p1 = new Pedido(kania);
		p1.adiciona(potim);
		p1.adiciona(saxe);
		pedidos.save(p1);
		
		Pedido p2 = new Pedido(tomzim);
		p2.adiciona(saxe);
		p2.adiciona(comidaQueElesNaoGosta);
		pedidos.save(p2);
	}

}
