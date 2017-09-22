package fr.pizzeria.ihm;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.IPizzaDAO;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;

public class AjouterPizzaOptionMenu extends OptionMenu{
	/**
	 * Ajouter des pizzas
	 */
	protected Scanner choix;
	protected IPizzaDAO dao;
	protected String libelle;
	
	public AjouterPizzaOptionMenu(Scanner choix, IPizzaDAO dao){
		this.choix = choix;
		this.dao = dao;
		this.libelle = "2. Ajouter une nouvelle pizza";
	}
	
	
	public void execute() throws InputMismatchException, StockageException {
		/** Choix des paramètres de la pizzas */
		
		choix.nextLine();

		System.out.println("Veuillez saisir le code");
		String code = choix.nextLine();
		if(code.length() != 3){
			throw new SavePizzaException("Le code doit avoir 3 lettres");
		}
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = choix.nextLine();
		if(nom.trim().isEmpty()){
			throw new SavePizzaException("Le nom ne doit pas être vide");
		}
			
		System.out.println("Veuillez saisir le prix");
	
		String prixStr = choix.nextLine();
			
		if(prixStr.trim().isEmpty()){
			throw new SavePizzaException("Le prix ne doit pas être vide");
		}
			
		double prix = Double.parseDouble(prixStr);
		
		dao.saveNewPizza(new Pizza(code, nom, prix));
	}
	
	public String getLibelle(){
		return libelle;
	}
}
