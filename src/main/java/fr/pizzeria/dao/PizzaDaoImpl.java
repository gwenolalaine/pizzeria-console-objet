package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;

public class PizzaDaoImpl implements IPizzaDAO{
	
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
	
	public List<Pizza> findAllPizzas(){
		for(int i = 0; i<pizzas.size(); i++){
			System.out.println(pizzas.get(i));
		}
		return pizzas;
	}
	
	public boolean saveNewPizza (Pizza pizza) throws SavePizzaException {
		pizzas.add(pizza);
		return true;
	}
	
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		for(int i = 0; i<pizzas.size(); i++){
			if(codePizza.equals(pizzas.get(i).getCode())){
				pizzas.get(i).setCode(pizza.getCode());
				pizzas.get(i).setNom(pizza.getNom());
				
				pizzas.get(i).setPrix(pizza.getPrix());
				return true;
			}
		}
		return false;
	}
	
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		for(int i = 0; i<pizzas.size(); i++){
			if(codePizza.equals(pizzas.get(i).getCode())){
				pizzas.remove(pizzas.get(i));
				return true;
			}
		}
		return false;
	}
	
	public boolean pizzaExists(String code){
		int i = 0;
		
		while(i < pizzas.size()){
			if((pizzas.get(i).getCode()).equals(code)){
				return true;
			}
			i++;
		}
		
		return false;
	}
	
	}
