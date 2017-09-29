package fr.pizzeria.ihm;

import java.io.IOException;

import fr.pizzeria.exception.StockageException;

public abstract class OptionMenu {
	protected String lib;
	protected Boolean execute;
	
	public String getLibelle(){
		return lib;
	}
	
	public abstract void execute() throws StockageException, IOException;
}
