package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Scanner;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.IPizzaDAO;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.CategoriePizza;

public class AjouterPizzaOptionMenu extends OptionMenu{
	/**
	 * Ajouter des pizzas
	 */
	protected Scanner choix;
	protected IPizzaDAO dao;
	protected String lib;
	
	public AjouterPizzaOptionMenu(Scanner choix, IPizzaDAO dao){
		this.choix = choix;
		this.dao = dao;
		this.lib = "2. Ajouter une nouvelle pizza";
	}
	
	
	public void execute() throws StockageException, IOException {
		/** Choix des paramètres de la pizzas */
		
		choix.nextLine();

		System.out.println("Veuillez saisir le code");
		String code = choix.nextLine();
		if(code.length() < 3){
			throw new SavePizzaException("Le code doit avoir au moins 3 lettres");
		}
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = choix.nextLine();
		if(nom.trim().isEmpty()){
			throw new SavePizzaException("Le nom ne doit pas être vide");
		}
		
		System.out.println("Veuillez choisir la catégorie (viande, poisson, sansviande)");
		String categorieStr = choix.nextLine().toUpperCase().trim();
		CategoriePizza categorie = null;
		if(categorieStr.equals("VIANDE")){
			categorie = CategoriePizza.VIANDE;
		}
		else if(categorieStr.equals("POISSON")){
			categorie = CategoriePizza.POISSON;
		}
		else if(categorieStr.equals("SANSVIANDE")){
			categorie = CategoriePizza.SANS_VIANDE;
		}
		else{
			throw new SavePizzaException("La catégorie doit être soit viande, poisson ou sans viande");
		}
			
		System.out.println("Veuillez saisir le prix");
	
		String prixStr = choix.nextLine();
			
		if(prixStr.trim().isEmpty()){
			throw new SavePizzaException("Le prix ne doit pas être vide");
		}
			
		double prix = Double.parseDouble(prixStr);
		
		dao.saveNewPizza(new Pizza(code, nom, prix, categorie));
	}
	
	@Override
	public String getLibelle(){
		return lib;
	}
}
