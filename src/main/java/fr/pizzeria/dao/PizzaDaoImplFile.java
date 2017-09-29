package fr.pizzeria.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.StringUtils;

public class PizzaDaoImplFile implements IPizzaDAO{
	
	List<Pizza> pizzas = new ArrayList<>();
	ObjectOutputStream oos = null;
	ObjectInputStream ois;
	File file = new File("pizzas.txt");
	
	public PizzaDaoImplFile(){
		try{
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(StringUtils.convert(new Pizza("PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE)) + "\r\n");
			bw.write(StringUtils.convert(new Pizza("MAR", "Margherita", 14.00, CategoriePizza.POISSON)) + "\r\n");
			bw.write(StringUtils.convert(new Pizza("REIN", "La Reine", 11.50, CategoriePizza.VIANDE)) + "\r\n");
			bw.write(StringUtils.convert(new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE)) + "\r\n");
			bw.write(StringUtils.convert(new Pizza("CAN", "La cannibale", 12.50, CategoriePizza.VIANDE)) + "\r\n");
			bw.write(StringUtils.convert(new Pizza("SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE)) + "\r\n");
			bw.write(StringUtils.convert(new Pizza("ORI", "L'orientale", 13.50, CategoriePizza.SANS_VIANDE)) + "\r\n");
			
			bw.flush();
			
			bw.close();
			fw.close();
			
			
		}catch (IOException ex) {  //This exception will be caught when EOF is reached
			 ex.printStackTrace();
            System.out.println("End of file reached.");
        }
	}
	
	public List<Pizza> findAllPizzas(){
		Path source = Paths.get("pizzas.txt");
		try ( 
			BufferedReader reader = Files.newBufferedReader(source, StandardCharsets.UTF_8) )  {
			String aux = "";
			StringBuilder bld = new StringBuilder();
			String str = "";
			while ((aux = reader.readLine()) != null) {
				bld.append(aux + "\r\n");
			}
			str = bld.toString();
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return pizzas;
	}
	
	public boolean saveNewPizza (Pizza pizza) throws SavePizzaException, IOException {
		
		
		Path source = Paths.get("pizzas.txt");
		String aux = "";
		StringBuilder bld = new StringBuilder();
		String str = "";
		try ( 
			BufferedReader reader = Files.newBufferedReader(source, StandardCharsets.UTF_8) )  {
			
			while ((aux = reader.readLine()) != null) {
				bld.append(aux + "\r\n");
			}
			str = bld.toString();
			System.out.println(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		FileWriter fw = new FileWriter(file);
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(str);
		bw.write(StringUtils.convert(pizza));
		
		bw.flush();
		
		bw.close();
		fw.close();
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
			System.out.println(pizzas.get(i).getCode());
			i++;
		}
		
		return false;
	}
	
	}
