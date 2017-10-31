package fr.pizzeria.ihm;


import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IPizzaDAO;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Categorie;
import fr.pizzeria.model.Pizza;

@Controller
public class ModifierPizzaOptionMenu extends OptionMenu{
	
	/** LOG Logger */
	private static final Logger LOG = LoggerFactory.getLogger(ModifierPizzaOptionMenu.class);
	/**
	 * Mise à jour d'une pizza
	 */
	@Autowired
	protected Scanner choix;
	@Autowired
	protected IPizzaDAO dao;
	protected String lib;
	
	public ModifierPizzaOptionMenu(){
		this.lib = "Mettre à jour une pizza";
	}
	
	public boolean execute() throws StockageException{
		/** Choix de la pizza à update */
		choix.nextLine();
		LOG.info("Choisir le code de la pizza à modifier");
		try {
			dao.findAllPizzas();
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		
		String toChange = choix.nextLine().toUpperCase();
		
		if(dao.pizzaExists(toChange)){
			/** Choix des paramètres de la pizza*/
			LOG.info("Veuillez saisir le code");
			String code = choix.nextLine();
			
			if(code.length() < 3){
				throw new SavePizzaException("Le code doit avoir au moins 3 lettres");
			}
				
			LOG.info("Veuillez saisir le nom (sans espace)");
			String nom = choix.nextLine();
			
			if(nom.trim().isEmpty()){
				throw new UpdatePizzaException("Le nom ne doit pas être vide");
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
				throw new UpdatePizzaException("Le prix ne doit pas être vide");
			}
			
			double prix = Double.parseDouble(prixStr);
				
			/** Changer les paramètres de la pizza en question */
			Categorie categ = dao.findCategorieById(categorie);
			dao.updatePizza(toChange, new Pizza(code, nom, prix, categ));
			return true;
		}else{
			throw new UpdatePizzaException("La pizza n'existe pas");
		}
		
		
	}
	
	@Override
	public String getLibelle(){
		return lib;
	}
}
