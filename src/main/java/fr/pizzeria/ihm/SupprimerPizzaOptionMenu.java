package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.dao.IPizzaDAO;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	protected Scanner choix;
	protected IPizzaDAO dao;
	protected String libelle;
	
	public SupprimerPizzaOptionMenu(Scanner choix,IPizzaDAO dao){
		this.choix = choix;
		this.dao = dao;
		this.libelle = "4. Supprimer une pizza";
	}
	/**
	 * Supprimer une pizza
	 * @throws StockageException 
	 */
	public void execute() throws StockageException{
		/** Choix de la pizza à supprimer */
		choix.nextLine();
		System.out.println("Choisir le code de la pizza à supprimer");
		try {
			dao.findAllPizzas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String toChange = choix.nextLine().toUpperCase();
		
		if(dao.pizzaExists(toChange)){
		/** Supprime la pizza dans la liste */
			dao.deletePizza(toChange);
		}else{
			throw new DeletePizzaException("La pizza n'existe pas");
		}
	}
	
	public String getLibelle(){
		return libelle;
	}
}
