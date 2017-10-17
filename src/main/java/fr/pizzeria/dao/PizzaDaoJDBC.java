package fr.pizzeria.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.Pizza;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Categorie;
import fr.pizzeria.model.CategoriePizza;

public class PizzaDaoJDBC implements IPizzaDAO{
	
List<Pizza> pizzas = new ArrayList<>();

/** LOG Logger */
private static final Logger LOG = LoggerFactory.getLogger(PizzaDaoJDBC.class);
	
	public Optional<Connection> connection(){
		ResourceBundle resource = ResourceBundle.getBundle("jdbc");
		
		try {
			Class.forName(resource.getString("jdbc.driver"));
			return Optional.of(DriverManager.getConnection(resource.getString("jdbc.url"), resource.getString("jdbc.user"), resource.getString("jdbc.password")));
		} catch (ClassNotFoundException|SQLException e) {
			LOG.error(e.getMessage());
		}
		
		return Optional.empty();
	}


	@Override
	public List<Pizza> findAllPizzas(){
		pizzas.clear();
		
		Optional<Connection> myConnection = connection();
		Optional<ResultSet> resultats = Optional.empty();
		try {
			if(myConnection.isPresent()){
				Statement statement = myConnection.get().createStatement();
				
				resultats = Optional.of(statement.executeQuery("SELECT * FROM pizza"));
				if(resultats.isPresent()){
					while(resultats.get().next()) {
						String code = resultats.get().getString("code");
						String name = resultats.get().getString("name");
						Double price = resultats.get().getDouble("prix");
						int categorie = resultats.get().getInt("categorieID");
						pizzas.add(new Pizza(code, name, price, categorie));
					}
		
					resultats.get().close();
				}
				statement.close();
				myConnection.get().close();
			}
			else{
				throw new NullPointerException();
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		} finally{
			if(myConnection.isPresent()){
				try {
					myConnection.get().close();
					if(resultats.isPresent()){
						resultats.get().close();
					}
				} catch (SQLException e) {
					LOG.error(e.getMessage());
				}
			}
		}
			
		return pizzas;
	}
	
	@Override
	public boolean saveNewPizza (Pizza pizza) throws SavePizzaException {
		return execute("INSERT into pizza(code, name, prix, categorieID) values ('" + pizza.getCode() + "','" + pizza.getNom() + "','" 
				+ pizza.getPrix() + "','" + pizza.getCategorie() + "')");
	}
	
	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		return execute("UPDATE pizza SET code='" + pizza.getCode() + "', name = '" + pizza.getNom()  + "', prix = '" + pizza.getPrix() + "', categorieID = '"  
					+ pizza.getCategorie() + "' WHERE code= '" + codePizza  + "'");
	}
	
	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		
		return execute("DELETE FROM pizza WHERE code=" + "\"" + codePizza + "\"" );
	}
	
	public boolean execute(String request){
		Optional<Connection> myConnection = connection();
		
		try {
			if(myConnection.isPresent()){
				PreparedStatement statement = null;
				statement = myConnection.get().prepareStatement(request);
				statement.executeUpdate();
				
				statement.close();
				myConnection.get().close();
				return true;
			}
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
		return false;

	}
	
	@Override
	public boolean pizzaExists(String code){
		return pizzas.stream().anyMatch(p->p.getCode().equals(code));
		
	}

}
