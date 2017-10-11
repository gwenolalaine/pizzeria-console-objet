package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;

public class PizzaDaoImpl implements IPizzaDAO{
	
	private static final Logger LOG = LoggerFactory.getLogger(PizzaDaoImpl.class);
	
	List<Pizza> pizzas = new ArrayList<>();
	
	public PizzaDaoImpl(){
		/** Ajoute les pizzas dans la liste */
		pizzas.add(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.POISSON));
		pizzas.add(new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.SANS_VIANDE));
	}
	
	@Override
	public List<Pizza> findAllPizzas(){
		pizzas.stream().forEach(p->LOG.info(p.toString()));
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
	
	}
