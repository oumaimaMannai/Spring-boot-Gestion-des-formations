package world.cup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import world.cup.models.Formateur;
import world.cup.repositories.FormateurRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/formateur")
@RestController
public class FormateurController {
	
	@Autowired
	FormateurRepository formateurRepository;
	
	
	@GetMapping("/formateurs")

	public List<Formateur> getAllFormateur() {
		List<Formateur> formateurs = formateurRepository.findAll();
		
	  return formateurs;
	}
	
	
	@GetMapping(value ="/formateur/{id}") 

  public Formateur afficherUnFormateur(@PathVariable int id) {
	  
	  Formateur formateur = formateurRepository.findById(id);
	  return formateur;
	  
  }
	
	
	@PostMapping("/addformateur")
	public Formateur createFomrateur(@RequestBody Formateur formateur) {
		return formateurRepository.save(formateur);
		
	}
	
	@DeleteMapping("/supprimerformateur/{id}")
	public void deleteConsultation(@PathVariable int id) {
		formateurRepository.deleteById(id);
		
	}
	
	@PostMapping("/updateformateur/{id}")
	public Formateur updateFormateur(@PathVariable(value = "id") Integer Id,@RequestBody Formateur formateur) {
	          
		Formateur f = formateurRepository.findById(Id).orElseThrow(null);
		
		f.setNom(formateur.getNom());
		f.setPrenom(formateur.getPrenom());
		f.setEmail(formateur.getEmail());
		f.setTel(formateur.getTel());
		
		f.setType(formateur.getType());
		f.setOrganisme(formateur.getOrganisme());

		
		
	f = formateurRepository.save(f);
	return f;
		
		
	}


}
