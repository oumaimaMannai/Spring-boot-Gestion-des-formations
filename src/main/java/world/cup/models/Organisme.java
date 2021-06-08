package world.cup.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="organisme")
public class Organisme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idOrganisme", nullable = false)
	private int idOrganisme;
	@Column
	private String Libelle;
	
	
	
	public Organisme(int idOrganisme, String libelle) {
		super();
		this.idOrganisme = idOrganisme;
		Libelle = libelle;
	}
	public Organisme() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdOrganisme() {
		return idOrganisme;
	}
	public void setIdOrganisme(int idOrganisme) {
		this.idOrganisme = idOrganisme;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	
}
