package be.shop.service;

import java.util.List;

import javax.ejb.Local;

import be.shop.entity.Categorie;

@Local
public interface CategorieServices {
	List<Categorie> findAll();

	Categorie findById(Long id);
	
	Categorie findByName(String name);
	
}
