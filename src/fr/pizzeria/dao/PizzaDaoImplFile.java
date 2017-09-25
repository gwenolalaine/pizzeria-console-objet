package fr.pizzeria.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;

public class PizzaDaoImplFile implements IPizzaDAO{
	
	ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	ObjectOutputStream oos = null;
	ObjectInputStream ois;
	
	public PizzaDaoImplFile(){
		try{
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File("pizzas.txt"))));
			
			oos.writeObject(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
			oos.writeObject(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.POISSON));
			oos.writeObject(new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE));
			oos.writeObject(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
			oos.writeObject(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
			oos.writeObject(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
			oos.writeObject(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.SANS_VIANDE));
			
			oos.close();
			
			
		}catch (EOFException ex) {  //This exception will be caught when EOF is reached
            System.out.println("End of file reached.");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
		/** Ajoute les pizzas dans la liste */
		
	}
	
	public Pizza[] findAllPizzas(){
		try{
			ois = new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(
								new File("pizzas.text"))));
		
				Object obj = null;
				while((obj = ois.readObject()) != null){
					System.out.println(((Pizza)ois.readObject()).toString());
				}
				 
	        } catch (EOFException ex) {  //This exception will be caught when EOF is reached
	            System.out.println("End of file reached.");
	        } catch (ClassNotFoundException ex) {
	            ex.printStackTrace();
	        } catch (FileNotFoundException ex) {
	            ex.printStackTrace();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } finally {
	            //Close the ObjectInputStream
	            try {
	                if (ois != null) {
	                    ois.close();
	                }
	            } catch (IOException ex) {
	                ex.printStackTrace();
	            }
	        }
		
		return null;
	};
	
	public boolean saveNewPizza (Pizza pizza) throws SavePizzaException {
		try{
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File("pizzas.txt"))));
					
			
			oos.writeObject(pizza);
			oos.close();
			
			
		}catch (EOFException ex) {  //This exception will be caught when EOF is reached
            System.out.println("End of file reached.");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
		for(int i = 0; i<pizzas.size(); i++){
			if(!code.equals(pizzas.get(i).getCode())){
				return false;
			}else{
				return true;
			}
		}
		return false;
	}
	
	}
