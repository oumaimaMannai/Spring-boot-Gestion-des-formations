package world.cup.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import world.cup.models.SessionFormation;




@Repository
public interface SessionRepository extends JpaRepository<SessionFormation,Integer>{
	SessionFormation findById(int id);
}