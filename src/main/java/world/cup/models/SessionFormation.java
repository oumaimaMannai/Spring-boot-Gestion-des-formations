package world.cup.models;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class SessionFormation {
	

	  
	
    


	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idSession ;
	
	private String lieu;
	
	private Date dateDebut;
	private Date dateFin;

	private int nbParticipant;
	private String nom ;
	

	 
	@ManyToOne
    @JoinColumn(name="idFormateur", nullable=false)
    private Formateur formateur;
	
	

	

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "sessionformation_formation", 
				joinColumns = @JoinColumn(name = "sessionformation_id"), 
				inverseJoinColumns = @JoinColumn(name = "formation_id"))
	private Set<Formation> formations = new HashSet<>();
	
	
	public Set<Formation> getFormations() {
		return formations;
	}
	public void setFormations(Set<Formation> formations) {
		this.formations = formations;
	}

	public Formateur getFormateur() {
		return formateur;
	}
	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	public int getIdSession() {
		return idSession;
	}
	public void setIdSession(int idSession) {
		this.idSession = idSession;
	}
	public String getLieu() {
		return lieu;
	}
	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	public Date getDateDebut() {
		return dateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public int getNbParticipant() {
		return nbParticipant;
	}
	public void setNbParticipant(int nbParticipant) {
		this.nbParticipant = nbParticipant;
	}






	@Override
	public String toString() {
		return "SessionFormation [idSession=" + idSession + ", lieu=" + lieu + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", nbParticipant=" + nbParticipant + ", nom=" + nom + ", formateur=" + formateur
				+ ", formations=" + formations + "]";
	}
	public SessionFormation(int idSession, String lieu, Date dateDebut, Date dateFin, int nbParticipant, String nom,
			Formateur formateur, Set<Formation> formations) {
		super();
		this.idSession = idSession;
		this.lieu = lieu;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.nbParticipant = nbParticipant;
		this.nom = nom;
		this.formateur = formateur;
		this.formations = formations;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public SessionFormation() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}


