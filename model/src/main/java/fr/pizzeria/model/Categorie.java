package fr.pizzeria.model;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categorie")
public class Categorie {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name ="type")
	private String type;
	
	public String toString(){
		return "de type " + this.type;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	public Categorie(){
	}
	
	public Categorie(int id){
		Map<Integer, CategoriePizza> options = new HashMap();
		options.put(1, CategoriePizza.VIANDE);
		options.put(2, CategoriePizza.SANS_VIANDE);
		options.put(3, CategoriePizza.POISSON);
		
		this.id = id;
		type = options.get(id).name();
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
	
	
}
