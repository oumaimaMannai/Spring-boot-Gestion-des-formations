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

import world.cup.models.Organisme;
import world.cup.repositories.OrganismeRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/organisme")

public class OrganismeController {
	
	@Autowired
	OrganismeRepository organismeRepository;
	
	@GetMapping(value ="/organisme")
	public List<Organisme> getAllOrganisme() {
		List<Organisme> organismes = organismeRepository.findAll();
		
	  return organismes;
	}
	
	@GetMapping(value ="/organisme/{id}") //URL
	public Organisme afficherUnOrganisme(@PathVariable int id){
		Organisme organisme = organismeRepository.findById(id);
			return organisme;
	}
	
	@PostMapping("/addorganisme")
	public Organisme createOrganisme( @RequestBody Organisme organisme) {
	    return organismeRepository.save(organisme);
	}
	
	
	@DeleteMapping("/deleteorganisme/{id}")
	public void deleteConsultation(@PathVariable int id) {
		organismeRepository.deleteById(id);
	}
	
	
	
	@PostMapping("/updateorganisme/{id}")
	public Organisme updateOrganisme(@PathVariable(value = "id") Integer Id,@RequestBody Organisme organisme) {
	          
		Organisme o = organismeRepository.findById(Id).orElseThrow(null);
	
	    o.setLibelle(organisme.getLibelle());
	    
	    o = organismeRepository.save(o);
		return o;
	}
}




