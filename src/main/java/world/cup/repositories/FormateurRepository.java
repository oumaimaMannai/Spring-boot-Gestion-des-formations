package world.cup.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import world.cup.models.Formateur;



public interface FormateurRepository extends JpaRepository<Formateur,Integer>{
	Formateur findById(int id);
}

