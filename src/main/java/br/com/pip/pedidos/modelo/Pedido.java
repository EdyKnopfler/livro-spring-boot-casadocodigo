package br.com.pip.pedidos.modelo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pedido {
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Pedido() {
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@ManyToOne(optional = true)
	private Cliente cliente;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Item> itens = new ArrayList<>();
	
	private LocalDate data = LocalDate.now();
	
	private BigDecimal valorTotal = new BigDecimal(0.00);

	public void adiciona(Item item) {
		itens.add(item);
		valorTotal = valorTotal.add(item.getPreco());
	}

	public Long getId() {
		return id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public LocalDate getData() {
		return data;
	}

	public List<Item> getItens() {
		return itens;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public static Pedido comItensPara(List<Item> itens, Cliente cliente) {
		Pedido pedido = new Pedido(cliente);
		for (Item i : itens) {
			pedido.adiciona(i);
		}
		return pedido;
	}
	
	

}
