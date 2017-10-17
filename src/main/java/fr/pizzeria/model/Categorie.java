package fr.pizzeria.model;

public class Categorie {

	int id;
	int compteur;
	CategoriePizza type;
	
	
	public Categorie(int id){
		this.id = id;
		if(id == 1){
			type = CategoriePizza.VIANDE;
		}else if(id == 2){
			type = CategoriePizza.SANS_VIANDE;
		}else if(id==3){
			type = CategoriePizza.POISSON;
		}
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the type
	 */
	public CategoriePizza getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(CategoriePizza type) {
		this.type = type;
	}
	
	
}
