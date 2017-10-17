package fr.pizzeria.console;

import java.io.Serializable;
import fr.pizzeria.model.StringUtils;
import fr.pizzeria.model.Categorie;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.ToString;


public class Pizza implements Serializable{
	/** Identifiant de la pizza */
	protected int id;
	/** Code de la pizza */
	@ToString(upperCase=true)
	protected String code;
	/** Nom de la pizza */
	@ToString(upperCase=false)
	protected String nom;
	/** Prix de la pizza */
	@ToString(upperCase=false)
	protected double prix;
	/** Id de categorie de la pizza */
	protected int categorie;
	/** Compteur pour incrémenter l'id*/
	protected static int compteur;
	/**Categorie de pizza*/
	@ToString(upperCase=true)
	protected String categoriePizza;
	
	/** Constructeur 
	 * @param code code
	 * @param nom nom
	 * @param prix prix
	 * */
	public Pizza(String code, String nom, double prix, int categorie) {
		compteur++;
		this.id = compteur;
		this.code = code.toUpperCase();
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		this.categoriePizza = new Categorie(this.categorie).getType().toString();
	}
	
	public Pizza(int id, String code, String nom, double prix, int categorie) {
		this.id = id;
		this.code = code.toUpperCase();
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
		this.categoriePizza = new Categorie(this.categorie).getType().toString();
	}
	
	/** @Override */
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
	public int getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the categoriePizza
	 */
	public String getCategoriePizza() {
		return categoriePizza.toString();
	}

	/**
	 * @param categoriePizza the categoriePizza to set
	 */
	public void setCategoriePizza(String categoriePizza) {
		this.categoriePizza = new Categorie(this.categorie).getType().toString();
	}
	
	
}
