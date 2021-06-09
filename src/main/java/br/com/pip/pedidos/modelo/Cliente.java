package br.com.pip.pedidos.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class Cliente {
	
	public Cliente(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull 
	@Size(min = 2, max = 50, message = "O nome deve ter entre {min} e {max} caracteres.")
	private String nome;

	@NotNull 
	@Size(min = 2, max = 300, message = "O endereço deve ter entre {min} e {max} caracteres.")
	private String endereco;
	
	@OneToMany(mappedBy = "cliente", fetch = FetchType.EAGER, cascade = CascadeType.ALL)	
	private List<Pedido> pedidos;
	
	

}
