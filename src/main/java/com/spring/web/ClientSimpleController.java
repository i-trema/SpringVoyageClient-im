package com.spring.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.spring.entities.Client;
import com.spring.repositories.ClientRepository;



@Controller
@RequestMapping("client")
public class ClientSimpleController {
@Autowired
ClientRepository clientRepository;
	
@GetMapping("")	
public String getClients(Model m) {
	Client c = new Client();
	m.addAttribute("clients", clientRepository.findAll());
	m.addAttribute("client", c);
	
	return "client";
}

@GetMapping("liste")	
public String listeClients(Model m) {

	m.addAttribute("clients", clientRepository.findAll());
	
	return "listeclients";
}

@PostMapping("/add")
public String addClient(@Valid @ModelAttribute(name = "client") Client c, BindingResult result, Model model) {
	if (result.hasErrors()) {
		model.addAttribute("clients", clientRepository.findAll());
		return "client";
	}
			clientRepository.save(c);	
	return "redirect:/client";
}

@PostMapping("edit/{id}")
public String editaddClient(@PathVariable long id, @Valid Client c1, BindingResult result, Model m) {
	if (result.hasErrors()) {
		m.addAttribute("client", c1);
		return "clientedit";
	}
	c1.setId(id);
	clientRepository.save(c1);	
	return "redirect:/client";
}

@RequestMapping(value = "delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
public String deleteClient(@PathVariable long id) {
	clientRepository.deleteById(id);
	return "redirect:/client";
}

@GetMapping(value = "edit/{id}")
public String editClient(@PathVariable long id, Model m) {
	Client c = clientRepository.findById(id).get();
	m.addAttribute("client", c);
	return "clientedit";
}

}
