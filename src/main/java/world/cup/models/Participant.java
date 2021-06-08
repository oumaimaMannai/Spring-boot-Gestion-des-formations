package world.cup.models;

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
public class Participant {
	




	@ManyToOne
    @JoinColumn(name="idOrganisme", nullable=false)
    private Organisme organisme;
	
	

	@ManyToOne
    @JoinColumn(name="idProfil", nullable=false)
    private Profil profil;

	
	
	@ManyToOne
    @JoinColumn(name="idPays", nullable=false)
    private Pays pays;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "sessionformation_participant", 
				joinColumns = @JoinColumn(name = "participant_id"), 
				inverseJoinColumns = @JoinColumn(name = "sessionformation_id"))
	private Set<SessionFormation> sessions = new HashSet<>();
	
	
	
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
	  
	//@ManyToOne
   // @JoinColumn(name="idDomaine", nullable=false)
   // private Domaine domaine;





	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}



	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int idParticipant ;
	
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}
	
	
	
	private String nom;
	private String prenom;
	private String type;
	private String email ;
	private int tel;
	
	
	
	
	public Organisme getOrganisme() {
		return organisme;
	}
	public void setOrganisme(Organisme organisme) {
		this.organisme = organisme;
	}
	

	public int getIdParticipant() {
		return idParticipant;
	}
	public void setIdParticipant(int idParticipant) {
		this.idParticipant = idParticipant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	

	

	
	
	
	

	@Override
	public String toString() {
		return "Participant [organisme=" + organisme + ", profil=" + profil + ", pays=" + pays + ", sessions="
				+ sessions + ", idParticipant=" + idParticipant + ", nom=" + nom + ", prenom=" + prenom + ", type="
				+ type + ", email=" + email + ", tel=" + tel + "]";
	}
	public Participant(Organisme organisme, Profil profil, Pays pays, Set<SessionFormation> sessions, int idParticipant,
			String nom, String prenom, String type, String email, int tel) {
		super();
		this.organisme = organisme;
		this.profil = profil;
		this.pays = pays;
		this.sessions = sessions;
		this.idParticipant = idParticipant;
		this.nom = nom;
		this.prenom = prenom;
		this.type = type;
		this.email = email;
		this.tel = tel;
	}
	public Set<SessionFormation> getSessions() {
		return sessions;
	}
	public void setSessions(Set<SessionFormation> sessions) {
		this.sessions = sessions;
	}
	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	


	

}

