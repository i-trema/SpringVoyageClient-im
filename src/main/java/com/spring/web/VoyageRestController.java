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

import com.spring.entities.Voyage;
import com.spring.repositories.VoyageRepository;

@RestController
@RequestMapping("apivoyage")
public class VoyageRestController {
@Autowired
VoyageRepository voyageRepository;
	
@GetMapping("")	
public List<Voyage> getVoyages()
{
	 return voyageRepository.findAll();
}
@GetMapping("{id}")
public Optional<Voyage> findVoyages(@PathVariable int id)
{
	 return voyageRepository.findById(id);
}
@PostMapping("")
public Voyage addVoyage(@Valid @RequestBody Voyage voyage) // valid => controller ou Rest 
// RB => uniquement RestController
{
return voyageRepository.save(voyage);	

}
@DeleteMapping("{id}")
public void deleteVoyage(@PathVariable int id) {
	voyageRepository.deleteById(id);
}


}
