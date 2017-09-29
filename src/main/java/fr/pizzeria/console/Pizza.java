package fr.pizzeria.console;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import fr.pizzeria.model.StringUtils;

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
	/** Categorie de la pizza */
	@ToString(upperCase=false)
	protected CategoriePizza categorie;
	/** Compteur pour incrémenter l'id*/
	protected static int compteur;

	/** Constructeur 
	 * @param code code
	 * @param nom nom
	 * @param prix prix
	 * */
	public Pizza(String code, String nom, double prix, CategoriePizza categorie) {
		compteur++;
		this.id = compteur;
		this.code = code.toUpperCase();
		this.nom = nom;
		this.prix = prix;
		this.categorie = categorie;
	}
	
	/** @Override */
	public String toString(){
		String str = StringUtils.convert(this);
		return str;
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
