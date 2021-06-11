package br.com.pip.pedidos.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.pip.pedidos.form.ClienteForm;
import br.com.pip.pedidos.modelo.Cliente;
import br.com.pip.pedidos.repositorio.ClienteRepository;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public String listar(Model model) {
		Iterable<Cliente> clientes = clienteRepository.findAll();
		model.addAttribute("clientes", clientes);
		return "clientes/listar";
	}
	
	@GetMapping("/{id}")
	public String detalhar(@PathVariable Long id, Model model) {
		Cliente cliente = clienteRepository.getById(id);
		model.addAttribute("cliente", cliente);
		return "clientes/detalhar";
	}
	
	@GetMapping("/novo")
	public String formNovo(ClienteForm cliente, Model model) {
		model.addAttribute("titulo", "Novo Cliente");
		return "clientes/novo";
	}
	
	@PostMapping("/novo")
	@Transactional
	public String gravarNovo(@Valid ClienteForm dados, BindingResult validacao) {
		if (validacao.hasErrors()) return "clientes/novo";
		Cliente novoCliente = dados.toCliente();
		clienteRepository.save(novoCliente);
		return "redirect:/clientes";
	}
	
	@GetMapping("/alterar/{id}")
	public String formAlterar(@PathVariable Long id, Model model) {
		Cliente cliente = clienteRepository.getById(id);
		model.addAttribute("clienteForm", cliente);
		model.addAttribute("titulo", "Alterar Cliente");
		return "clientes/alterar";
	}
	
	@PostMapping("/alterar/{id}")
	@Transactional									
	public String gravarAlteracao(@PathVariable Long id, @Valid ClienteForm dados, BindingResult validacao) {
		if (validacao.hasErrors()) return "clientes/alterar";
		Cliente cliente = clienteRepository.getById(id);
		dados.preencher(cliente);
		return "redirect:/clientes";
	}
	
	@GetMapping("/remover/{id}")
	@Transactional
	public String remover(@PathVariable Long id) {
		clienteRepository.deleteById(id);
		return "redirect:/clientes";
	}
	
}
