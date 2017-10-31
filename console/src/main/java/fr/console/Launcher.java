package fr.console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConfig;
import fr.pizzeria.dao.IPizzaDAO;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Pizza;

/**
 * @author ETY19
 *
 */
/**
 * @author ETY19
 *
 */
public class Launcher {
	
	/** LOG Logger */
	@Autowired
	private Logger LOG;
	/** Liste de pizzas */
	static List<Pizza> pizzas = new ArrayList<>();
	/** Instance du scanner */
	@Autowired
	static Scanner scanner;
	
	public static void main(String[] args) throws StockageException, IOException{
		
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class)) {
			IPizzaDAO dao = context.getBean(IPizzaDAO.class);
			Menu menu = context.getBean(Menu.class);
			/** Boolean pour sortir de la boucle */
			boolean out = false;
			/** Boucle du scanner */
			while(!out){
				menu.demarrer();
			}
			
		}	
	}
}
