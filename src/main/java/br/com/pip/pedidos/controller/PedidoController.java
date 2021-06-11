package br.com.pip.pedidos.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pip.pedidos.dto.RespostaDTO;
import br.com.pip.pedidos.form.PedidoForm;
import br.com.pip.pedidos.modelo.Cliente;
import br.com.pip.pedidos.modelo.Item;
import br.com.pip.pedidos.modelo.Pedido;
import br.com.pip.pedidos.repositorio.ClienteRepository;
import br.com.pip.pedidos.repositorio.ItemRepository;
import br.com.pip.pedidos.repositorio.PedidoRepository;

// O pedido seria feito por app móvel!

@RestController
@RequestMapping("/rest/pedidos")
public class PedidoController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@PostMapping
	public RespostaDTO criar(@RequestBody @Valid PedidoForm dados, BindingResult validacao) {
		if (validacao.hasErrors()) {
			return new RespostaDTO(null, null, 
					validacao.getFieldErrors().stream()
						.map(e -> e.getField() + " " + e.getDefaultMessage())
						.reduce("", (subtotal, element) -> subtotal + " / " + element));
		}
		
		Optional<Cliente> cliente = clienteRepository.findById(dados.getClienteId());
		
		if (!cliente.isPresent()) {
			return new RespostaDTO(null, null, "Cliente não encontrado");
		}
		
		List<Item> itens = itemRepository.findAllById(dados.getItemIds());
		
		if (itens.size() != dados.getItemIds().size()) {
			List<String> ids = itens.stream().map(i -> String.valueOf(i.getId())).collect(Collectors.toList());
			return new RespostaDTO(null, null, "Somente os itens " + ids + " foram encontrados");
		}
		
		Pedido novoPedido = Pedido.comItensPara(itens, cliente.get());
		pedidoRepository.save(novoPedido);
		return new RespostaDTO(novoPedido.getValorTotal(), novoPedido.getId(), "Criado com sucesso!");
	}

}
