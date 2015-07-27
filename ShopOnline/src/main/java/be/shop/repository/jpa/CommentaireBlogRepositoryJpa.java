package be.shop.repository.jpa;

import java.util.List;

import javax.ejb.Stateless;

import be.shop.entity.CommentaireBlog;
import be.shop.repository.CommentaireBlogRepository;

/**
 * Session Bean implementation class CommentaireBlogRepositoryJpa
 */
@Stateless
public class CommentaireBlogRepositoryJpa extends
		GenericRepositoryJpa<CommentaireBlog> implements
		CommentaireBlogRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<CommentaireBlog> findByClient(Long client) {
		return getEntityManager()
				.createNamedQuery("CommentaireBlog.findByClient")
				.setParameter("client", client).getResultList();
	}

}
