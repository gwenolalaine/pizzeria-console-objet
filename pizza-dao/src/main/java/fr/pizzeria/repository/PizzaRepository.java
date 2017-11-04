package fr.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer>{
	public Pizza findByCode(String code);
}
