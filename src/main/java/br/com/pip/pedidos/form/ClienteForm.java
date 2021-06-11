package br.com.pip.pedidos.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.pip.pedidos.modelo.Cliente;

public class ClienteForm {
	
	public ClienteForm(String nome, String endereco) {
		this.nome = nome;
		this.endereco = endereco;
	}
	
	@NotBlank 
	@Size(min = 2, max = 50, message = "O nome deve ter entre {min} e {max} caracteres.")
	private String nome;

	@NotBlank 
	@Size(min = 2, max = 300, message = "O endereço deve ter entre {min} e {max} caracteres.")
	private String endereco;
	
	public String getNome() {
		return nome;
	}
	
	public String getEndereco() {
		return endereco;
	}

	public Cliente toCliente() {
		return new Cliente(nome, endereco);
	}

	public void preencher(Cliente cliente) {
		cliente.setNome(nome);
		cliente.setEndereco(endereco);
	}
	
}
