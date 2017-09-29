package fr.pizzeria.ihm;

import java.io.IOException;
import java.util.InputMismatchException;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;

public abstract class OptionMenu {
	protected String libelle;
	protected Boolean execute;
	
	public String getLibelle(){
		return libelle;
	}
	
	public abstract void execute() throws StockageException, InputMismatchException, IOException;
}
