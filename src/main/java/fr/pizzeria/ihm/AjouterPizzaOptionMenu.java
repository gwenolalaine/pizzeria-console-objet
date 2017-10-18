package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.IPizzaDAO;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Categorie;

public class AjouterPizzaOptionMenu extends OptionMenu{
	
	/** LOG Logger */
	private static final Logger LOG = LoggerFactory.getLogger(AjouterPizzaOptionMenu.class);
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

		LOG.info("Veuillez saisir le code");
		String code = choix.nextLine();
		if(code.length() < 3){
			throw new SavePizzaException("Le code doit avoir au moins 3 lettres");
		}
		
		LOG.info("Veuillez saisir le nom (sans espace)");
		String nom = choix.nextLine();
		if(nom.trim().isEmpty()){
			throw new SavePizzaException("Le nom ne doit pas être vide");
		}
		
		LOG.info("Veuillez choisir la catégorie (viande, poisson, sansviande)");
		String categorieStr = choix.nextLine().toUpperCase().trim();
		int categorie = 0;
		if(categorieStr.equals("VIANDE")){
			categorie = 1;
		}
		else if(categorieStr.equals("POISSON")){
			categorie = 3;
		}
		else if(categorieStr.equals("SANSVIANDE")){
			categorie = 2;
		}
		else{
			throw new SavePizzaException("La catégorie doit être soit viande, poisson ou sans viande");
		}
			
		LOG.info("Veuillez saisir le prix");
	
		String prixStr = choix.nextLine();
			
		if(prixStr.trim().isEmpty()){
			throw new SavePizzaException("Le prix ne doit pas être vide");
		}
			
		double prix = Double.parseDouble(prixStr);
		
		Categorie categ = dao.findCategorieById(categorie);
		dao.saveNewPizza(new Pizza(code, nom, prix, categ));
	}
	
	@Override
	public String getLibelle(){
		return lib;
	}
}
