package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.Scanner;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//tableau de pizzas
		ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
		
		
			//initialiser les pizzas
		//créer tous les objets dans la liste
		Pizza pep = new Pizza("PEP", "Pépéroni", 12.50);
		Pizza mar = new Pizza("MAR", "Margherita", 14.00);
		Pizza rein = new Pizza("REIN", "La Reine", 11.50);
		Pizza fro = new Pizza("FRO", "La 4 fromages", 12.00);
		Pizza can = new Pizza("CAN", "La cannibale", 12.50);
		Pizza sav = new Pizza("SAV", "La savoyarde", 13.00);
		Pizza ori = new Pizza("ORI", "L'orientale", 13.50);
			
		pizzas.add(pep);
		pizzas.add(mar);
		pizzas.add(rein);
		pizzas.add(fro);
		pizzas.add(can);
		pizzas.add(sav);
		pizzas.add(ori);
		
		boolean out = false;
		
		
		while(out == false){
			System.out.println("***** Pizzeria Administration *****\r");
			System.out.println("1. Lister les pizzas\r");
			System.out.println("2. Ajouter une nouvelle pizza\r");
			System.out.println("3. Mettre à jour une pizza\r");
			System.out.println("4. Supprimer une pizza\r");
			System.out.println("99. Sortir");
			Scanner choix = new Scanner(System.in);
			int rep = choix.nextInt();
			
			if(rep == 1){
				for(int i = 0; i<pizzas.size(); i++){
					System.out.println(pizzas.get(i).ToString());
				}
			}
			
			else if(rep == 2){
				System.out.println("Veuillez saisir le code");
				Scanner choixCode = new Scanner(System.in);
				String code = choixCode.nextLine();
				
				System.out.println("Veuillez saisir le nom (sans espace)");
				Scanner choixNom = new Scanner(System.in);
				String nom = choixNom.nextLine();
				
				System.out.println("Veuillez saisir le prix");
				Scanner choixPrix = new Scanner(System.in);
				Double prix = choixPrix.nextDouble();
				
				pizzas.add(new Pizza(code, nom, prix));
			}
			
			else if(rep == 3){
				System.out.println("Choisir le code de la pizza à modifier");
				for(int i = 0; i<pizzas.size(); i++){
					System.out.println(pizzas.get(i).ToString());
				}
				System.out.println("99 pour abandonner");
				
				Scanner choixChangement = new Scanner(System.in);
				String toChange = choixChangement.nextLine();
				
				System.out.println("Veuillez saisir le code");
				Scanner choixCode = new Scanner(System.in);
				String code = choixCode.nextLine();
				
				System.out.println("Veuillez saisir le nom (sans espace)");
				Scanner choixNom = new Scanner(System.in);
				String nom = choixNom.nextLine();
				
				System.out.println("Veuillez saisir le prix");
				Scanner choixPrix = new Scanner(System.in);
				Double prix = choixPrix.nextDouble();
				
				for(int i = 0; i<pizzas.size(); i++){
					if(toChange.equals(pizzas.get(i).getCode())){
						pizzas.get(i).setCode(code);
						pizzas.get(i).setNom(nom);
						pizzas.get(i).setPrix(prix);
					}
				}
			}
			
			else if(rep == 4){
				System.out.println("Choisir le code de la pizza à supprimer");
				for(int i = 0; i<pizzas.size(); i++){
					System.out.println(pizzas.get(i).ToString());
				}
				
				Scanner choixChangement = new Scanner(System.in);
				String toChange = choixChangement.nextLine();
				
				for(int i = 0; i<pizzas.size(); i++){
					if(toChange.equals(pizzas.get(i).getCode())){
						pizzas.remove(pizzas.get(i));
					}
				}
			}
			
			else if(rep == 99){
				out = true;
			}
			
			
		}
		//Menu
			//1 lister les pizzas
			//2 ajouter des pizzas
			//3 mettre à jour les pizzas
			//4 supprimer une pizza
			//99 sortir
	}

}
