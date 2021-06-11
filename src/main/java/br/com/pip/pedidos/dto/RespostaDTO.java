package br.com.pip.pedidos.dto;

import java.math.BigDecimal;

public class RespostaDTO {
	
	private BigDecimal valorTotal;
	private Long pedido;
	private String mensagem;
	
	public RespostaDTO(BigDecimal valorTotal, Long pedido, String mensagem) {
		super();
		this.valorTotal = valorTotal;
		this.pedido = pedido;
		this.mensagem = mensagem;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public Long getPedido() {
		return pedido;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	

}
