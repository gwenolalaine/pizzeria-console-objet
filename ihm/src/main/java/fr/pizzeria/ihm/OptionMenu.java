package fr.pizzeria.ihm;


import java.io.IOException;

import org.springframework.stereotype.Controller;

import fr.pizzeria.exception.StockageException;

@Controller
public abstract class OptionMenu {
	protected String libelle;
	protected Boolean execute;
	
	public String getLibelle(){
		return libelle;
	}
	
	public abstract boolean execute() throws StockageException, IOException;
}
