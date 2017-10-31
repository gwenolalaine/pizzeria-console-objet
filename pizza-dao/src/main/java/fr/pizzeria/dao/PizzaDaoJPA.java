package fr.pizzeria.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.pizzeria.exception.StockageException;
import fr.pizzeria.model.Categorie;
import fr.pizzeria.model.Pizza;

@Repository
public class PizzaDaoJPA implements IPizzaDAO {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pizzeria");
	List<Pizza> pizzas = new ArrayList<>();
	
	@Override
	public List<Pizza> findAllPizzas() throws IOException {
		
		EntityManager em = entityManagerFactory.createEntityManager();
		
		TypedQuery<Pizza> queryF = em.createQuery("FROM Pizza", Pizza.class);
		pizzas = queryF.getResultList();
		
		em.close();
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws StockageException, IOException {
		EntityManager em = entityManagerFactory.createEntityManager();
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		em.persist(pizza);
		
		tr.commit();
		em.close();
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws StockageException {
		EntityManager em = entityManagerFactory.createEntityManager();
		
		TypedQuery<Pizza> query = em.createQuery("SELECT pizza FROM Pizza pizza WHERE pizza.code=?", Pizza.class);
		
		Pizza toModif = query.setParameter(1, codePizza).getSingleResult();
		if(toModif != null){
			EntityTransaction tr = em.getTransaction();
			tr.begin();
			pizza.setId(toModif.getId());
			
			em.merge(pizza);
			
			tr.commit();
			em.close();
		}
		
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws StockageException {
		EntityManager em = entityManagerFactory.createEntityManager();
		
		TypedQuery<Pizza> query = em.createQuery("SELECT pizza FROM Pizza pizza WHERE pizza.code=?", Pizza.class);
		Pizza toModif = query.setParameter(1, codePizza).getSingleResult();
		
		EntityTransaction tr = em.getTransaction();
		tr.begin();
		
		em.remove(toModif);
				
		tr.commit();
		em.close();
		
		return false;
	}

	@Override
	public boolean pizzaExists(String toChange) {
		return pizzas.stream().anyMatch(p->p.getCode().equals(toChange));
	}
	
	public Categorie findCategorieById(int categorie){
		EntityManager em = entityManagerFactory.createEntityManager();

		return em.find(Categorie.class, categorie);
	}

}
