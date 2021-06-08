package world.cup.repositories;



	import org.springframework.data.jpa.repository.JpaRepository;

import world.cup.models.Organisme;



	public interface OrganismeRepository extends JpaRepository<Organisme,Integer>{
		Organisme findById(int id);
	}

