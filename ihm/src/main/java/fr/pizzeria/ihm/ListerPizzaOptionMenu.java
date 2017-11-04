package fr.pizzeria.ihm;


import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import fr.pizzeria.dao.IPizzaDAO;

@Controller
public class ListerPizzaOptionMenu extends OptionMenu{
	
	private static final Logger LOG = LoggerFactory.getLogger(ListerPizzaOptionMenu.class);
	@Autowired
	IPizzaDAO dao;
	String lib;
	
	public ListerPizzaOptionMenu(){
		this.lib = "Lister les pizzas";
	}
	
	@Override
	public boolean execute() throws IOException{
		dao.findAllPizzas().stream().forEach(p->LOG.info(p.toString()));
		return true;
	}
	
	@Override
	public String getLibelle(){
		return lib;
	}
}
