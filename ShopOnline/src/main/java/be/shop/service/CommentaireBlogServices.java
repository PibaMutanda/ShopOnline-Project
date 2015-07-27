package be.shop.service;

import java.util.List;

import javax.ejb.Local;

import be.shop.entity.CommentaireBlog;

@Local
public interface CommentaireBlogServices {
	
	List<CommentaireBlog> findByClient(Long client);
}
