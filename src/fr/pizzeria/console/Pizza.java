package fr.pizzeria.console;

import fr.pizzeria.model.CategoriePizza;

public class Pizza {
	/** Identifiant de la pizza */
	protected int id;
	/** Code de la pizza */
	protected String code;
	/** Nom de la pizza */
	protected String nom;
	/** Prix de la pizza */
	protected double prix;
	/** Compteur pour incrémenter l'id*/
	protected static int compteur;
	
	protected CategoriePizza categorie;
	/** Constructeur 
	 * @param code code
	 * @param nom nom
	 * @param prix prix
	 * */
	public Pizza(String code, String nom, double prix) {
		compteur++;
		this.id = compteur;
		this.code = code.toUpperCase();
		this.nom = nom;
		this.prix = prix;
	}
	
	/** @Override */
	public String toString(){
		return code + "->" + nom + " (" + prix + "€) " + categorie;
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
	public CategoriePizza getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}
}
