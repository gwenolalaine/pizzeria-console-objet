package fr.pizzeria.ihm;


import java.io.IOException;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IPizzaDAO;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.StockageException;

@Controller
public class SupprimerPizzaOptionMenu extends OptionMenu {
	/** LOG Logger */
	private static final Logger LOG = LoggerFactory.getLogger(AjouterPizzaOptionMenu.class);
	
	@Autowired
	protected Scanner choix;
	@Autowired
	protected IPizzaDAO dao;
	protected String lib;
	
	public SupprimerPizzaOptionMenu(){
		this.lib = "Supprimer une pizza";
	}
	/**
	 * Supprimer une pizza
	 * @throws StockageException 
	 */
	public boolean execute() throws StockageException{
		/** Choix de la pizza à supprimer */
		choix.nextLine();
		LOG.info("Choisir le code de la pizza à supprimer");
		try {
			dao.findAllPizzas();
		} catch (IOException e) {
			LOG.error(e.getMessage());
		}
		
		String toChange = choix.nextLine().toUpperCase();
		
		if(dao.pizzaExists(toChange)){
		/** Supprime la pizza dans la liste */
			dao.deletePizza(toChange);
		}else{
			throw new DeletePizzaException("La pizza n'existe pas");
		}
		return true;
	}
	
	@Override
	public String getLibelle(){
		return lib;
	}
}
