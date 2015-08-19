package be.shop.repository.jpa;

import java.util.List;

import javax.ejb.Stateless;

import be.shop.entity.Article;
import be.shop.entity.Categorie;
import be.shop.entity.Commande;
import be.shop.repository.ArticleRepository;

/**
 * Session Bean implementation class ArticleRepositoryJpa
 */
@Stateless
public class ArticleRepositoryJpa extends GenericRepositoryJpa<Article>
		implements ArticleRepository {

	/**
	 * @see GenericRepositoryJpa#GenericRepositoryJpa()
	 */

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> findByCateg(Categorie categ) {
		return getEntityManager().createNamedQuery("Article.findByCateg")
				.setParameter("categ", categ).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> findByCommande(Commande commande) {
		return getEntityManager().createNamedQuery("Article.findByCommande")
				.setParameter("commande", commande).getResultList();
	}

}
