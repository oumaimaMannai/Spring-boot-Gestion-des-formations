package world.cup.controller;

import java.util.HashSet;

import java.util.List;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import world.cup.models.Formation;
import world.cup.models.Participant;
import world.cup.models.Role;
import world.cup.repositories.FormationRepository;

@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/formation")
@RestController
public class FormationController {
	
	@Autowired
	FormationRepository formationRepository;
	
	@GetMapping("/formations")
	public List<Formation> getAllFormation() {
		List<Formation> formations = formationRepository.findAll();
		
	  return formations;
	}
		
	@GetMapping(value ="/formation/{id}") //URL
  public Formation afficherUnFormation(@PathVariable int id) {
	  
	  Formation formation = formationRepository.findById(id);
	  return formation;
	  
  }
	@PostMapping("/addformation")
	public Formation createFomration(@RequestBody Formation formation) {
	
		return formationRepository.save(formation);
		
	}
	
	@DeleteMapping("/supprimerformation/{id}")
	public void deleteConsultation(@PathVariable int id) {
		formationRepository.deleteById(id);
		
	}
	
	@PostMapping("/updateformation/{id}")
	public Formation updateFormation(@PathVariable(value = "id") Integer Id,@RequestBody Formation formation) {
	          
		Formation f = formationRepository.findById(Id).orElseThrow(null);
		
		f.setBudget(formation.getBudget());
		f.setDomaine(formation.getDomaine());
		f.setDuree(formation.getDuree());
		f.setTitre(formation.getTitre());
		f.setNb_session(formation.getNb_session());
		f.setDomaine(formation.getDomaine());


		
	    f = formationRepository.save(f);
	    return f;
		
	}
	}


