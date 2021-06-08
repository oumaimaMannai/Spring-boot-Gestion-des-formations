package world.cup.controller;

import java.util.List;
import java.util.Set;

import javax.websocket.Session;

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

import world.cup.models.Formation;
import world.cup.models.Participant;
import world.cup.models.SessionFormation;

import world.cup.repositories.SessionRepository;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/session")

public class SessionController {
	
    @Autowired
	SessionRepository sessionRepository;
	
	@GetMapping(value ="/sessions")
	public List<SessionFormation> getAllSessions() {
		List<SessionFormation> sessions =sessionRepository.findAll();
		
	  return sessions;
	}
	
	@GetMapping(value ="/session/{id}") //URL
	public SessionFormation afficherUnSession(@PathVariable int id){
		SessionFormation session = sessionRepository.findById(id);
			return session;
	}
	
	@PostMapping("/addsession")
	public SessionFormation createSession( @RequestBody SessionFormation session) {
		
		
		Set<Formation> formations = session.getFormations();
		session.setFormations(formations);
		
	    return sessionRepository.save(session);
	}
	
	
	@DeleteMapping("/deletesession/{id}")
	public void deleteSession(@PathVariable int id) {
		sessionRepository.deleteById(id);
	}
	
	
	
	@PostMapping("/updatesession/{id}")
	public SessionFormation updateSession(@PathVariable(value = "id") Integer Id,@RequestBody SessionFormation session) {
	          
		SessionFormation s = sessionRepository.findById(Id).orElseThrow(null);
	
	    s.setDateDebut(session.getDateDebut());
	    s.setDateFin(session.getDateFin());
	    s.setDateDebut(session.getDateDebut());
	    s.setLieu(session.getLieu());
	    s.setNom(session.getNom());
	    s.setNbParticipant(session.getNbParticipant());
	    s.setFormateur(session.getFormateur());

	    
	    s = sessionRepository.save(s);
		return s;
	}
	

}
