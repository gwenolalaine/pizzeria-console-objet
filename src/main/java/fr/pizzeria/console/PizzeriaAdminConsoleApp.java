package fr.pizzeria.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDAO;
import fr.pizzeria.dao.PizzaDaoImpl;
import fr.pizzeria.dao.PizzaDaoImplFile;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.SupprimerPizzaOptionMenu;

/**
 * @author ETY19
 *
 */
/**
 * @author ETY19
 *
 */
public class PizzeriaAdminConsoleApp {
	/** Liste de pizzas */
	static ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	/** Instance du scanner */
	static Scanner choix = new Scanner(System.in);
	
	public static void main(String[] args) throws StockageException, InputMismatchException, IOException{
		// TODO Auto-generated method stub
			
		
		
		/** Boolean pour sortir de la boucle */
		boolean out = false;
		
		IPizzaDAO dao = new PizzaDaoImpl();
		
		PizzeriaAdminConsoleApp app = new PizzeriaAdminConsoleApp();
		AjouterPizzaOptionMenu add = new AjouterPizzaOptionMenu(choix, dao);
		ModifierPizzaOptionMenu update = new ModifierPizzaOptionMenu(choix, dao);
		SupprimerPizzaOptionMenu delete = new SupprimerPizzaOptionMenu(choix, dao);
		
		
		
		/** Boucle du scanner */
		while(out == false){
			/** Liste des intructions pour l'utilisateurs */
			System.out.println("***** Pizzeria Administration *****\r");
			System.out.println("1. Lister les pizzas");
			System.out.println(add.getLibelle());
			System.out.println(update.getLibelle());
			System.out.println(delete.getLibelle());
			System.out.println("99. Sortir");
			int rep = 0;
			/** Réponse de l'utilisateur */
			try{
				String repStr = choix.nextLine();
				rep = Integer.parseInt(repStr);
			}
			catch(NumberFormatException e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			
			/** Liste les pizzas */
			try{
				if(rep == 1){
					dao.findAllPizzas();
				}
				
				/** Ajouter des pizzas */
				else if(rep == 2){
					add.execute();
				}
				
				/** Updater des pizzas */
				else if(rep == 3){
					update.execute();
				}
				
				/** Supprimer des pizzas */
				else if(rep == 4){
					delete.execute();
				}
				
				/** Sortir du programme */
				else if(rep == 99){
					out = true;
				}
			}catch(StockageException e){
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	
	
	
	
	

}
