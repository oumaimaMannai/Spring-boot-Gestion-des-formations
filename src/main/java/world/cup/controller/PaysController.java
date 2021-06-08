package world.cup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import world.cup.models.Pays;

import world.cup.repositories.PaysRepository;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/pays")

public class PaysController {
	
	@Autowired
	PaysRepository paysRepository;
	
	@GetMapping(value ="/pays")
	public List<Pays> getAllPays() {
		List<Pays> pays = paysRepository.findAll();
		
	  return  pays;
	}
	
	@GetMapping(value ="/pays/{id}") //URL
	public Pays afficherUnPays(@PathVariable int id){
		Pays pays = paysRepository.findById(id);
			return pays;
	}
	
	@PostMapping("/addpays")
	public Pays createPays( @RequestBody Pays pays) {
	    return paysRepository.save(pays);
	}
	
	
	@DeleteMapping("/deletepays/{id}")
	public void deletePays(@PathVariable int id) {
		paysRepository.deleteById(id);
	}
	
	
	
	@PostMapping("/updatepays/{id}")
	public Pays updatePays(@PathVariable(value = "id") Integer Id,@RequestBody Pays pays) {
	          
		Pays p = paysRepository.findById(Id).orElseThrow(null);
	
	    p.setLibelle(pays.getLibelle());
	    
	    p= paysRepository.save(p);
		return p;
	}
}





