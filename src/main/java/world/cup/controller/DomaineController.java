package world.cup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import world.cup.models.Domaine;

import world.cup.repositories.DomaineRepository;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/domaine")

public class DomaineController {
	
    @Autowired
	DomaineRepository domaineRepository;
	
    
	@GetMapping(value ="/domaines")
	public List<Domaine> getAllDomaines() {
		List<Domaine> domaines = domaineRepository.findAll();
		
	  return domaines;
	}
	
	@GetMapping(value ="/domaine/{id}") //URL
	public Domaine afficherUnDomaine(@PathVariable int id){
		Domaine domaine = domaineRepository.findById(id);
			return domaine;
	}
	
	@PostMapping("/adddomaine")
	public Domaine createDomaine( @RequestBody Domaine domaine) {
	    return domaineRepository.save(domaine);
	}
	
	
	@DeleteMapping("/deletedomaine/{id}")
	public void deleteDomaine(@PathVariable int id) {
		domaineRepository.deleteById(id);
	}
	
	
	
	@PutMapping("/updatedomaine/{id}")
	public Domaine updateDomaine(@PathVariable(value = "id") Integer Id,@RequestBody Domaine domaine) {
	          
		Domaine d = domaineRepository.findById(Id).orElseThrow(null);
	
	    domaine.setLibelle(domaine.getLibelle());
	    
	    d = domaineRepository.save(domaine);
		return domaine;
	}
}
