package fr.pizzeria.exception;

public class SavePizzaException extends StockageException {
	public SavePizzaException(){
		super("Cette pizza existe désolée");
	}
	
	public SavePizzaException(String msg){
		super(msg);
	}
}
