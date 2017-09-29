package fr.pizzeria.dao;

import java.io.IOException;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;

public interface IPizzaDAO {
	Pizza[] findAllPizzas() throws IOException;
	boolean saveNewPizza(Pizza pizza) throws StockageException, IOException;
	boolean updatePizza(String codePizza, Pizza pizza) throws StockageException;
	boolean deletePizza(String codePizza) throws StockageException;
	boolean pizzaExists(String toChange);
}
