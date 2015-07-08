package be.shop.repository;

import javax.ejb.Local;

import be.shop.entity.CommentaireBlog;

@Local
public interface CommentaireBlogRepository extends
		GenericRepository<CommentaireBlog> {

}
