package br.com.pip.pedidos.form;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ItemForm {
	
	public ItemForm(String nome, BigDecimal preco) {
		this.nome = nome;
		this.preco = preco;
	}
	
	@NotNull
	@Size(min = 2, max = 50, message = "O nome deve ter entre {min} e {max} caracteres.")
	private String nome;
	
	@NotNull
	private BigDecimal preco;

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

}
