package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

/**
 * @author ETY19
 *
 */
/**
 * @author ETY19
 *
 */
public class PizzeriaAdminConsoleApp {
	/** Liste de pizzas */
	static ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	/** Instance du scanner */
	static Scanner choix = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PizzeriaAdminConsoleApp app = new PizzeriaAdminConsoleApp();
		
		/** Pizzas initialisées */
		Pizza pep = new Pizza("PEP", "Pépéroni", 12.50);
		Pizza mar = new Pizza("MAR", "Margherita", 14.00);
		Pizza rein = new Pizza("REIN", "La Reine", 11.50);
		Pizza fro = new Pizza("FRO", "La 4 fromages", 12.00);
		Pizza can = new Pizza("CAN", "La cannibale", 12.50);
		Pizza sav = new Pizza("SAV", "La savoyarde", 13.00);
		Pizza ori = new Pizza("ORI", "L'orientale", 13.50);
			
		/** Ajoute les pizzas dans la liste */
		pizzas.add(pep);
		pizzas.add(mar);
		pizzas.add(rein);
		pizzas.add(fro);
		pizzas.add(can);
		pizzas.add(sav);
		pizzas.add(ori);
		
		/** Boolean pour sortir de la boucle */
		boolean out = false;
		
		/** Boucle du scanner */
		while(out == false){
			/** Liste des intructions pour l'utilisateurs */
			System.out.println("***** Pizzeria Administration *****\r");
			System.out.println("1. Lister les pizzas\r");
			System.out.println("2. Ajouter une nouvelle pizza\r");
			System.out.println("3. Mettre à jour une pizza\r");
			System.out.println("4. Supprimer une pizza\r");
			System.out.println("99. Sortir");
			
			/** Réponse de l'utilisateur */
			int rep = choix.nextInt();
			
			/** Liste les pizzas */
			if(rep == 1){
				app.listPizzas();
			}
			
			/** Ajouter des pizzas */
			else if(rep == 2){
				app.addPizzas();
			}
			
			/** Updater des pizzas */
			else if(rep == 3){
				app.updatePizzas();
			}
			
			/** Supprimer des pizzas */
			else if(rep == 4){
				app.deletePizzas();
			}
			
			/** Sortir du programme */
			else if(rep == 99){
				out = true;
			}
		}
	}
	
	/**
	 * Methode qui affiche la liste des pizzas
	 */
	public void listPizzas(){
		/** Simple boucle pour montrer la liste des pizzas */
		for(int i = 0; i<pizzas.size(); i++){
			System.out.println(pizzas.get(i).ToString());
		}
	}
	
	/**
	 * Ajouter des pizzas
	 */
	public void addPizzas(){
		/** Choix des paramètres de la pizzas */
		choix.nextLine();
		System.out.println("Veuillez saisir le code");
		String code = choix.nextLine();
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = choix.nextLine();
		
		System.out.println("Veuillez saisir le prix");
		Double prix = choix.nextDouble();
		
		/** Ajouter la pizza à la liste */
		pizzas.add(new Pizza(code, nom, prix));
	}
	
	/**
	 * Mise à jour d'une pizza
	 */
	public void updatePizzas(){
		/** Choix de la pizza à update */
		choix.nextLine();
		System.out.println("Choisir le code de la pizza à modifier");
		listPizzas();
		
		String toChange = choix.nextLine();
		
		/** Choix des paramètres de la pizza*/
		System.out.println("Veuillez saisir le code");
		String code = choix.nextLine();
		
		System.out.println("Veuillez saisir le nom (sans espace)");
		String nom = choix.nextLine();
		
		System.out.println("Veuillez saisir le prix");
		Double prix = choix.nextDouble();
		
		/** Changer les paramètres de la pizza en question */
		for(int i = 0; i<pizzas.size(); i++){
			if(toChange.equals(pizzas.get(i).getCode())){
				pizzas.get(i).setCode(code);
				pizzas.get(i).setNom(nom);
				pizzas.get(i).setPrix(prix);
			}
		}
	}
	
	/**
	 * Supprimer une pizza
	 */
	public void deletePizzas(){
		/** Choix de la pizza à supprimer */
		choix.nextLine();
		System.out.println("Choisir le code de la pizza à supprimer");
		listPizzas();
		
		String toChange = choix.nextLine();
		
		/** Supprime la pizza dans la liste */
		for(int i = 0; i<pizzas.size(); i++){
			if(toChange.equals(pizzas.get(i).getCode())){
				pizzas.remove(pizzas.get(i));
			}
		}
	}

}
