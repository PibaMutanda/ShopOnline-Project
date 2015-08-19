package be.shop.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.shop.entity.Categorie;
import be.shop.repository.CategorieRepository;
import be.shop.service.CategorieServices;

@Stateless
public class CategorieServicesImpl   implements CategorieServices {
	
	@EJB
	private CategorieRepository categorieRepository;

	public void setCategorieRepository(CategorieRepository categorieRepository) {
		this.categorieRepository = categorieRepository;
	}

	@Override
	public Categorie findByName(String name) {
		return categorieRepository.findByName(name);
	}

}
