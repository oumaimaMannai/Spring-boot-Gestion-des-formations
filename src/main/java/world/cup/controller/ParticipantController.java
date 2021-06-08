package world.cup.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import world.cup.models.Participant;
import world.cup.models.SessionFormation;
import world.cup.repositories.ParticipantRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/participant")
@RestController
public class ParticipantController {
	
	@Autowired
	ParticipantRepository participantRepository;
	
	@GetMapping("/participants")
	public List<Participant> getAllParticipant() {
		List<Participant> participants = participantRepository.findAll();
		
	  return participants;
	}
		
	@GetMapping(value ="/participant/{id}") //URL
  public Participant afficherUnParticipant(@PathVariable int id) {
	  
	  Participant participant = participantRepository.findById(id);
	  return participant;
	  
  }
	@PostMapping("/addparticipant")
	public Participant createParticipant(@RequestBody Participant participant) {
		
		participant.setSessions(participant.getSessions());
		return participantRepository.save(participant);
		
	}
	
	@DeleteMapping("/supprimerparticipant/{id}")
	public void deleteParticipant(@PathVariable int id) {
		participantRepository.deleteById(id);
		
	}
	
	@PostMapping("/updateparticipant/{id}")
	public Participant updateParticipant(@PathVariable(value = "id") Integer Id,@RequestBody Participant participant) {
	          
		Participant p = participantRepository.findById(Id).orElseThrow(null);
		
		p.setNom(participant.getNom());
		p.setPrenom(participant.getPrenom());
		p.setEmail(participant.getEmail());
		p.setTel(participant.getTel());
		p.setType(participant.getType());
		p.setPays(participant.getPays());
		p.setOrganisme(participant.getOrganisme());
		p.setProfil(participant.getProfil());	
		
		
	    p= participantRepository.save(p);
	    return p;
		
		
}}
