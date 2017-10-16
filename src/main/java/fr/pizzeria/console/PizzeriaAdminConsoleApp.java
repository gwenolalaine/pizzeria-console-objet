package fr.pizzeria.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.dao.IPizzaDAO;
import fr.pizzeria.dao.PizzaDaoJDBC;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.AjouterPizzaOptionMenu;
import fr.pizzeria.ihm.ListerPizzaOptionMenu;
import fr.pizzeria.ihm.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.OptionMenu;
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
	
	/** LOG Logger */
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	/** Liste de pizzas */
	static List<Pizza> pizzas = new ArrayList<>();
	/** Instance du scanner */
	static Scanner choix = new Scanner(System.in);
	
	
	
	public static void main(String[] args) throws StockageException, IOException{
		/** Boolean pour sortir de la boucle */
		boolean out = false;
		
		IPizzaDAO dao = new PizzaDaoJDBC();
		
		AjouterPizzaOptionMenu add = new AjouterPizzaOptionMenu(choix, dao);
		ModifierPizzaOptionMenu update = new ModifierPizzaOptionMenu(choix, dao);
		SupprimerPizzaOptionMenu delete = new SupprimerPizzaOptionMenu(choix, dao);
		ListerPizzaOptionMenu lister = new ListerPizzaOptionMenu(dao);
		
		Map<Integer, OptionMenu> options = new HashMap();
		options.put(1, lister);
		options.put(2, add);
		options.put(3, update);
		options.put(4, delete);
		
		
		/** Boucle du scanner */
		while(!out){
			/** Liste des intructions pour l'utilisateurs */
			LOG.info("***** Pizzeria Administration *****\r");
			LOG.info(lister.getLibelle());
			LOG.info(add.getLibelle());
			LOG.info(update.getLibelle());
			LOG.info(delete.getLibelle());
			LOG.info("99. Sortir");
			
			int rep = 0;
			/** Réponse de l'utilisateur */
			
			try{
				String repStr = choix.nextLine();
				rep = Integer.parseInt(repStr);
			}
			catch(NumberFormatException e){
				LOG.error(e.getMessage());
			}
			
			if(rep == 99){
				out = true;
			}
			
			/** Liste les pizzas */
			try{
				options.get(rep).execute();
				
			}catch(StockageException e){
				LOG.error(e.getMessage());
			}
		}
	}
}
