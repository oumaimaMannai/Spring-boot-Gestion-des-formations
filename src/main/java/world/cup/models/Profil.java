package world.cup.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profil")
public class Profil {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idProfil", nullable = false)
	private int idProfil;
	
	
	@Column
	private String Libelle;
	
	
	
	
	public int getIdProfil() {
		return idProfil;
	}
	public void setIdProfil(int idProfil) {
		this.idProfil = idProfil;
	}
	public String getLibelle() {
		return Libelle;
	}
	public void setLibelle(String libelle) {
		Libelle = libelle;
	}
	public Profil(int idProfil, String libelle) {
		super();
		this.idProfil = idProfil;
		Libelle = libelle;
	}
	
	public Profil() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Profil(String libelle) {
		super();
		Libelle = libelle;
	}
	@Override
	public String toString() {
		return "Profil [idProfil=" + idProfil + ", Libelle=" + Libelle + "]";
	}
	
	
	
	
	
}
