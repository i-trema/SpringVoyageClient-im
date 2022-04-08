package com.spring.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.entities.Client;
import com.spring.repositories.ClientRepository;



@RestController
@RequestMapping("apiclient")
public class ClientRestController {
@Autowired
ClientRepository clientRepository;
	
@GetMapping	
public List<Client> getClients()
{
	 return clientRepository.findAll();
}
@GetMapping("{id}")
public Optional<Client> findClients(@PathVariable long id)
{
	 return clientRepository.findById(id);
}
@PostMapping
public Client addClient(@Valid @RequestBody Client client) // valid => controller ou Rest 
// RB => uniquement RestController
{
return clientRepository.save(client);	

}
@DeleteMapping("{id}")
public void deleteClient(@PathVariable long id) {
	clientRepository.deleteById(id);
}


}
