package be.shop.repository.jpa;

import java.util.List;

import javax.ejb.Stateless;

import be.shop.entity.Article;
import be.shop.repository.ArticleRepository;

/**
 * Session Bean implementation class ArticleRepositoryJpa
 */
@Stateless
public class ArticleRepositoryJpa extends GenericRepositoryJpa<Article> implements ArticleRepository {
       
    /**
     * @see GenericRepositoryJpa#GenericRepositoryJpa()
     */
   
	@SuppressWarnings("unchecked")
	@Override
	public List<Article> findByCateg(Long idCateg) {
		return getEntityManager().createNamedQuery("Article.findByCateg").setParameter("id", idCateg).getResultList();
	}

}
