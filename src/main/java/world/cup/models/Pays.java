package world.cup.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pays")
public class Pays {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPays", nullable = false)
	private int idPays;
	
	
	@Column
	private String Libelle;


	public int getIdPays() {
		return idPays;
	}


	public void setIdPays(int idPays) {
		this.idPays = idPays;
	}


	public String getLibelle() {
		return Libelle;
	}


	public void setLibelle(String libelle) {
		Libelle = libelle;
	}


	public Pays(int idPays, String libelle) {
		super();
		this.idPays = idPays;
		Libelle = libelle;
	}


	public Pays() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Pays [idPays=" + idPays + ", Libelle=" + Libelle + "]";
	}
	
	
	
	
	
	
}
