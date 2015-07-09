package be.shop.repository.jpa;

import javax.ejb.Stateless;

import be.shop.entity.Categorie;
import be.shop.repository.CategorieRepository;

/**
 * Session Bean implementation class CategorieRepositoryJpa
 */
@Stateless
public class CategorieRepositoryJpa extends GenericRepositoryJpa<Categorie>
		implements CategorieRepository {

}
