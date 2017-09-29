package fr.pizzeria.exception;

public class DeletePizzaException extends StockageException{
	public DeletePizzaException(){
		super("Cette pizza n'existe pas");
	}
	
	public DeletePizzaException(String msg){
		super(msg);
	}
}
