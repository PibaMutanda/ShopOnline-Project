package be.shop.repository.jpa;

import java.util.List;

import javax.ejb.Stateless;

import be.shop.entity.Categorie;
import be.shop.repository.CategorieRepository;

/**
 * Session Bean implementation class CategorieRepositoryJpa
 */
@Stateless
public class CategorieRepositoryJpa extends GenericRepositoryJpa<Categorie>
		implements CategorieRepository {

	@SuppressWarnings("unchecked")
	@Override
	public Categorie findByName(String name) {
		Categorie categorie = null;
		List<Categorie> categories = getEntityManager()
				.createNamedQuery("Categorie.findByName")
				.setParameter("nom", name).getResultList();
		if (!categories.isEmpty())
			categorie = categories.get(0);
		return categorie;
	}

}
