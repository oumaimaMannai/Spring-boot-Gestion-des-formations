package world.cup.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import world.cup.models.Domaine;





public interface DomaineRepository extends JpaRepository<Domaine,Integer>{
	Domaine findById(int id);
	//ArrayList<Domaine> findAll();
}
