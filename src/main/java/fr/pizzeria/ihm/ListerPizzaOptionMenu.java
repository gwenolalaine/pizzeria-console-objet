package fr.pizzeria.ihm;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.pizzeria.console.PizzeriaAdminConsoleApp;
import fr.pizzeria.dao.IPizzaDAO;

public class ListerPizzaOptionMenu extends OptionMenu{
	
	private static final Logger LOG = LoggerFactory.getLogger(PizzeriaAdminConsoleApp.class);
	IPizzaDAO dao;
	String lib;
	
	public ListerPizzaOptionMenu(IPizzaDAO dao){
		this.dao = dao;
		this.lib = "1. Lister les pizzas";
	}
	
	@Override
	public void execute() throws IOException{
		dao.findAllPizzas().stream().forEach(p->LOG.info(p.toString()));
	}
	
	@Override
	public String getLibelle(){
		return lib;
	}
}
