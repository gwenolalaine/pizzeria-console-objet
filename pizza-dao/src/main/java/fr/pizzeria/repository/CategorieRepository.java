package fr.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.pizzeria.model.Categorie;

public interface CategorieRepository extends JpaRepository<Categorie, Integer>{
	public Categorie findById(int id);
}
