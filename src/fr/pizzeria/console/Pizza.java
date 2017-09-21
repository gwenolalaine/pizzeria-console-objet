package fr.pizzeria.console;

public class Pizza {
	protected int id;
	protected String code;
	protected String nom;
	protected double prix;
	protected static int compteur;
	
	public Pizza(String code, String nom, double prix) {
		compteur++;
		this.id = compteur;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
	}
	
	public String ToString(){
		return code + "->" + nom + " (" + prix + "€)";
	}
	
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
		this.code = code;
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
}
