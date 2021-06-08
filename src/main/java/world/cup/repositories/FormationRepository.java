package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.cup.models.Formation;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Integer>{
	
	 Formation findById(int id);
	
}
