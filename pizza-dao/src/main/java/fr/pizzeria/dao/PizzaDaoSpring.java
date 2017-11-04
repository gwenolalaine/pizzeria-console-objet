package fr.pizzeria.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Categorie;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.repository.CategorieRepository;
import fr.pizzeria.repository.PizzaRepository;

@Repository
public class PizzaDaoSpring implements IPizzaDAO{
	@Autowired
	private PizzaRepository pizzaRepository;
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Override
	public List<Pizza> findAllPizzas() throws IOException {
		return pizzaRepository.findAll();	
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws StockageException, IOException {
		return pizzaRepository.save(pizza) != null;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws StockageException {
		pizza.setCode(codePizza);
		return pizzaRepository.save(pizza) != null;
	}

	@Override
	public boolean deletePizza(String codePizza) throws StockageException {
		pizzaRepository.delete(pizzaRepository.findByCode(codePizza));
		return true;
	}

	@Override
	public boolean pizzaExists(String toChange) {
		return 	pizzaRepository.findByCode(toChange) != null;
	}

	@Override
	public Categorie findCategorieById(int categorie) {
		return categorieRepository.findById(categorie);
	}

}
