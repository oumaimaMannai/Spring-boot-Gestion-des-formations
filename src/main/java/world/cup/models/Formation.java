package world.cup.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity

public class Formation {
	
	
/*
	
	public Formation(Set<SessionFormation> lessessions, Domaine domaine, long id,
			String titre, String type_formation, int nb_session, int durée, double budget) {
		super();
		this.lessessions = lessessions;
		
		this.domaine = domaine;
		this.id = id;
		this.titre = titre;
		this.type_formation = type_formation;
		this.nb_session = nb_session;
		this.durée = durée;
		this.budget = budget;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "formations")
	 private Set<SessionFormation> lessessions = new HashSet<>();
	
	
*/
	
	
	
	
	



	@ManyToOne
    @JoinColumn(name="idDomaine", nullable=false)
    private Domaine domaine;

	


public Domaine getDomaine() {
	return domaine;
}
public void setDomaine(Domaine domaine) {
	this.domaine = domaine;
}

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id ;
	
	private String titre;
	
	private String type_formation;
	private int nb_session;
	private int duree ;
	
	
	
	
	private double budget;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getType_formation() {
		return type_formation;
	}
	public void setType_formation(String type_formation) {
		this.type_formation = type_formation;
	}
	public int getNb_session() {
		return nb_session;
	}
	public void setNb_session(int nb_session) {
		this.nb_session = nb_session;
	}
	public int getDuree() {
		return duree;
	}
	public void setDuree(int durée) {
		this.duree = durée;
	}
	public double getBudget() {
		return budget;
	}
	public void setBudget(double budget) {
		this.budget = budget;
	}
	public Formation() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Formation [domaine=" + domaine + ", id=" + id + ", titre=" + titre + ", type_formation="
				+ type_formation + ", nb_session=" + nb_session + ", duree=" + duree + ", budget=" + budget + "]";
	}
	public Formation(Domaine domaine, Set<SessionFormation> sessionformations, int id, String titre,
			String type_formation, int nb_session, int duree, double budget) {
		super();
		this.domaine = domaine;
		this.id = id;
		this.titre = titre;
		this.type_formation = type_formation;
		this.nb_session = nb_session;
		this.duree = duree;
		this.budget = budget;
	}
	

	

}
