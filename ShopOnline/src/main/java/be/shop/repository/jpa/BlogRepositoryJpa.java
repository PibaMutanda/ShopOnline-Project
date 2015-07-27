package be.shop.repository.jpa;

import java.util.List;

import javax.ejb.Stateless;

import be.shop.entity.Blog;
import be.shop.repository.BlogRepository;

/**
 * Session Bean implementation class BlogRepositoryJpa
 */
@Stateless
public class BlogRepositoryJpa extends GenericRepositoryJpa<Blog> implements
		BlogRepository {

	/**
	 * @see GenericRepositoryJpa#GenericRepositoryJpa()
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<Blog> findByTitre(String titre) {

		return getEntityManager().createNamedQuery("Blog.findByTitre")
				.setParameter("titre","%"+ titre.toLowerCase() +"%").getResultList();
	}

}
