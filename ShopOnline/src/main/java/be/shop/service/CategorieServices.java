package be.shop.service;


import javax.ejb.Local;

import be.shop.entity.Categorie;

@Local
public interface CategorieServices {
	
	Categorie findByName(String name);
	
}
