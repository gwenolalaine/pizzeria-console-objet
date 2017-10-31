package fr.pizzeria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="pizza")
public class Pizza implements Serializable{
	/** Identifiant de la pizza */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int id;
	/** Code de la pizza */
	@ToString(upperCase=true)
	@Column(name ="code")
	protected String code;
	/** Nom de la pizza */
	@Column(name ="name")
	@ToString(upperCase=false)
	protected String nom;
	/** Prix de la pizza */
	@Column(name ="prix")
	@ToString(upperCase=false)
	protected double prix;
	
	/** Id de categorie de la pizza */
	@ManyToOne
	@JoinColumn(name="categorieID")
	@ToString(upperCase=false)
	protected Categorie categorie;
	
	/** Constructeur 
	 * @param code code
	 * @param nom nom
	 * @param prix prix
	 * */
	public Pizza(){}
	
	public Pizza(String code, String nom, double prix, Categorie categorie) {
		this.code = code.toUpperCase();
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	public Pizza(int id, String code, String nom, double prix, Categorie categorie) {
		this.id = id;
		this.code = code.toUpperCase();
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	@Override
	public String toString(){
		return StringUtils.convert(this);
	}

	/** Getters and setters */
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code.toUpperCase();
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
}
