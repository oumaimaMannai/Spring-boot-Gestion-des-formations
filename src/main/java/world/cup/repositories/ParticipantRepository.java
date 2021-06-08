package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import world.cup.models.Participant;



public interface ParticipantRepository extends JpaRepository<Participant,Integer>{
	Participant findById(int id);
}
