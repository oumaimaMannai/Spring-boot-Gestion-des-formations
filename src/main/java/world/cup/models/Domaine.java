package world.cup.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="domaine")
public class Domaine {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idDomaine", nullable = false)
	private int idDomaine;
	
	
	@Column
	private String Libelle;


	public int getIdDomaine() {
		return idDomaine;
	}


	public void setIdDomaine(int idDomaine) {
		this.idDomaine = idDomaine;
	}


	public String getLibelle() {
		return Libelle;
	}


	public void setLibelle(String libelle) {
		Libelle = libelle;
	}


	public Domaine(int idDomaine, String libelle) {
		super();
		this.idDomaine = idDomaine;
		Libelle = libelle;
	}


	public Domaine() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Domaine [idDomaine=" + idDomaine + ", Libelle=" + Libelle + "]";
	}
	
	
	
	
	
}
