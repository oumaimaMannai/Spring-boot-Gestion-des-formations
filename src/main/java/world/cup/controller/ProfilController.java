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


import world.cup.models.Profil;

import world.cup.repositories.ProfilRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/profil")

public class ProfilController {
	
	@Autowired
	ProfilRepository profilRepository;
	
	@GetMapping(value ="/profils")
	public List<Profil> getAllProfil() {
		List<Profil> profils = profilRepository.findAll();
		
	  return  profils;
	}
	
	@GetMapping(value ="/profil/{id}") //URL
	public Profil afficherUnProfil(@PathVariable int id){
		Profil profil = profilRepository.findById(id);
			return profil;
	}
	
	@PostMapping("/addprofil")
	public Profil createProfil( @RequestBody Profil profil) {
	    return profilRepository.save(profil);
	}
	
	
	@DeleteMapping("/deleteprofil/{id}")
	public void deleteProfil(@PathVariable int id) {
		profilRepository.deleteById(id);
	}
	
	
	
	@PostMapping("/updateprofil/{id}")
	public Profil updateProfil(@PathVariable(value = "id") Integer Id,@RequestBody Profil profil) {
	          
		Profil p = profilRepository.findById(Id).orElseThrow(null);
	
	    p.setLibelle(profil.getLibelle());
	    
	    p= profilRepository.save(p);
		return p;
	}
}





