package br.com.pip.pedidos.modelo;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Item {
	
	public Item(String nome, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min = 2, max = 50, message = "O nome deve ter entre {min} e {max} caracteres.")
	private String nome;
	
	@NotNull
	private BigDecimal preco;

	public BigDecimal getPreco() {
		return preco;
	}

}
