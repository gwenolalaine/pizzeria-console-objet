package fr.pizzeria.ihm;

import java.util.List;
import java.util.Scanner;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.IPizzaDAO;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;

public class ModifierPizzaOptionMenu extends OptionMenu{
	/**
	 * Mise à jour d'une pizza
	 */
	protected Scanner choix;
	protected IPizzaDAO dao;
	protected String libelle;
	
	public ModifierPizzaOptionMenu(Scanner choix, IPizzaDAO dao){
		this.choix = choix;
		this.dao = dao;
		this.libelle = "3. Mettre à jour une pizza";
	}
	
	public void execute() throws StockageException{
		/** Choix de la pizza à update */
		choix.nextLine();
		System.out.println("Choisir le code de la pizza à modifier");
		dao.findAllPizzas();
		
		String toChange = choix.nextLine().toUpperCase();
		
		if(dao.pizzaExists(toChange)){
			/** Choix des paramètres de la pizza*/
			System.out.println("Veuillez saisir le code");
			String code = choix.nextLine();
			
			if(code.length() != 3){
				throw new SavePizzaException("Le code doit avoir 3 lettres");
			}
				
			System.out.println("Veuillez saisir le nom (sans espace)");
			String nom = choix.nextLine();
			
			if(nom.trim().isEmpty()){
				throw new UpdatePizzaException("Le nom ne doit pas être vide");
			}
					
			System.out.println("Veuillez saisir le prix");
			
			String prixStr = choix.nextLine();
					
			if(prixStr.trim().isEmpty()){
				throw new UpdatePizzaException("Le prix ne doit pas être vide");
			}
			
			double prix = Double.parseDouble(prixStr);
				
			/** Changer les paramètres de la pizza en question */
			dao.updatePizza(toChange, new Pizza(code, nom, prix));
		}else{
			throw new UpdatePizzaException("La pizza n'existe pas");
		}
		
	}
	
	public String getLibelle(){
		return libelle;
	}
}
