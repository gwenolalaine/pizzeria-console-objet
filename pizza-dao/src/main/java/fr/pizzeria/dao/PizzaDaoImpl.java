package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Categorie;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImpl implements IPizzaDAO{
	
	List<Pizza> pizzas = new ArrayList<>();
	/** LOG Logger */
	private static final Logger LOG = LoggerFactory.getLogger(PizzaDaoImpl.class);
	
	public PizzaDaoImpl(){
		/** Ajoute les pizzas dans la liste */
		try {
			saveNewPizza(new Pizza("PEP", "Pépéroni", 12.50, new Categorie(1)));
			saveNewPizza(new Pizza("MAR", "Margherita", 14.00, new Categorie(3)));
			saveNewPizza(new Pizza("REIN", "La Reine", 11.50, new Categorie(1)));
			saveNewPizza(new Pizza("FRO", "La 4 fromages", 12.00, new Categorie(2)));
			saveNewPizza(new Pizza("CAN", "La cannibale", 12.50, new Categorie(1)));
			saveNewPizza(new Pizza("SAV", "La savoyarde", 13.00, new Categorie(1)));
			saveNewPizza(new Pizza("ORI", "L'orientale", 13.50, new Categorie(2)));
		} catch (SavePizzaException e) {
			LOG.error(e.getMessage());
		}
		
	}
	
	@Override
	public List<Pizza> findAllPizzas(){
		return pizzas;
	}
	
	@Override
	public boolean saveNewPizza (Pizza pizza) throws SavePizzaException {
		pizzas.add(pizza);
		return true;
	}
	
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		pizzas.stream().filter(p->p.getCode().equalsIgnoreCase(codePizza))
				.map(p->{
					p.setCode(pizza.getCode().toUpperCase());
					p.setNom(pizza.getNom());
					p.setPrix(pizza.getPrix());
					p.setCategorie(pizza.getCategorie());
					return Stream.of(p);
				})
				.collect(Collectors.toList());
		
		return false;
	}
	
	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		List<Pizza> toDelete = pizzas.stream().filter(p->p.getCode().equalsIgnoreCase(codePizza)).collect(Collectors.toList());
		
		pizzas.removeAll(toDelete);
		
		return false;
	}
	
	@Override
	public boolean pizzaExists(String code){
		return pizzas.stream().anyMatch(p->p.getCode().equals(code));
		
	}
	
	public Categorie findCategorieById(int categorie){
		return new Categorie(categorie);
	}
	
	}
