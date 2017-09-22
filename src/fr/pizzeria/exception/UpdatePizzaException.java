package fr.pizzeria.exception;

public class UpdatePizzaException extends StockageException{
	public UpdatePizzaException(){
		super("Cette pizza n'existe pas");
	}
	
	public UpdatePizzaException(String msg){
		super(msg);
	}
}
