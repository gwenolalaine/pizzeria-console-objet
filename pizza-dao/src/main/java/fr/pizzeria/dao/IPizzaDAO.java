package fr.pizzeria.dao;

import java.io.IOException;
import java.util.List;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Categorie;
import fr.pizzeria.model.Pizza;

public interface IPizzaDAO {
	List<Pizza> findAllPizzas() throws IOException;
	boolean saveNewPizza(Pizza pizza) throws StockageException, IOException;
	boolean updatePizza(String codePizza, Pizza pizza) throws StockageException;
	boolean deletePizza(String codePizza) throws StockageException;
	boolean pizzaExists(String toChange);
	Categorie findCategorieById(int categorie);
}
