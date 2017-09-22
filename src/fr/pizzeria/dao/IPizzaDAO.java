package fr.pizzeria.dao;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;

public interface IPizzaDAO {
	Pizza[] findAllPizzas();
	boolean saveNewPizza(Pizza pizza) throws StockageException;
	boolean updatePizza(String codePizza, Pizza pizza) throws StockageException;
	boolean deletePizza(String codePizza) throws StockageException;
	boolean pizzaExists(String toChange);
}
