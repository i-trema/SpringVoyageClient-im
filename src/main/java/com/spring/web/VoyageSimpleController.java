package com.spring.web;

import java.awt.print.Pageable;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.entities.Voyage;
import com.spring.repositories.VoyageRepository;

@Controller
@RequestMapping("voyage")
public class VoyageSimpleController {
	@Autowired
	VoyageRepository voyageRepository;
	
	@GetMapping("")
	public String getVoyages(Model m, Sort pageable) {
		Voyage v = new Voyage();
		m.addAttribute("voyages", voyageRepository.findAll(pageable));
		m.addAttribute("voyage", v);
		
		return "voyage";
	}
	
	@PostMapping("add")
	public String addVoyage(@Valid @ModelAttribute(name = "voyage") Voyage v, BindingResult result, Model m, Sort pageable) {
		if (result.hasErrors()){
			m.addAttribute("voyages", voyageRepository.findAll(pageable));
			return "voyage";
		}
		voyageRepository.save(v);	
		return "redirect:/voyage";
	}
	
	@PostMapping("edit/{id}")
	public String addEditedVoyage(@PathVariable int id, @Valid Voyage v1, BindingResult result2, Model mo) {
		if (result2.hasErrors()){
			mo.addAttribute("voyage", v1);
			return "voyageedit";
		}
		
		v1.setId(id);
		voyageRepository.save(v1);	
		return "redirect:/voyage";
	}
	
	@RequestMapping(value = "delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public String deleteVoyage(@PathVariable int id) {
		voyageRepository.deleteById(id);
		return "redirect:/voyage";
	}
	
	@GetMapping(value = "edit/{id}")
	public String editVoyage(@PathVariable int id, Model m) {
		Voyage v = voyageRepository.findById(id).get();
		m.addAttribute("voyage", v);
		return "voyageedit";
	}

	
//	@DeleteMapping(value = "delete/{id}")
//	public String deleteVoyage(@PathVariable int id) {
//		voyageRepository.deleteById(id);
//		return "voyage";
//	}
}
