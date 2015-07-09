package be.shop.repository;

import java.util.List;

import javax.ejb.Local;

import be.shop.entity.CommentaireBlog;

@Local
public interface CommentaireBlogRepository extends
		GenericRepository<CommentaireBlog> {

	List<CommentaireBlog> findByClient(Long id);
}
