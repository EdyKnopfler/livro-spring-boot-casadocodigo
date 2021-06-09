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
import javax.validation.constraints.Min;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pedido {
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@ManyToOne(optional = true)
	private Cliente cliente;
	
	@ManyToMany(cascade = CascadeType.MERGE)
	private List<Item> itens = new ArrayList<>();
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate data = LocalDate.now();
	
	@Min(1)
	private BigDecimal valorTotal = new BigDecimal(0.00);

	public void adiciona(Item item) {
		itens.add(item);
		valorTotal = valorTotal.add(item.getPreco());
	}

}
