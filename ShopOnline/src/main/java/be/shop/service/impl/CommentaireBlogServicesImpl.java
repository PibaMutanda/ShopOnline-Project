package be.shop.service.impl;

import java.util.List;

import javax.ejb.EJB;

import be.shop.entity.CommentaireBlog;
import be.shop.repository.CommentaireBlogRepository;
import be.shop.service.CommentaireBlogServices;

public class CommentaireBlogServicesImpl implements CommentaireBlogServices {

	@EJB(name="commentaireBlogRepository")
	private CommentaireBlogRepository commentaireBlogRepo;
	
	
	public void setCommentaireBlogRepo(CommentaireBlogRepository commentaireBlogRepo) {
		this.commentaireBlogRepo = commentaireBlogRepo;
	}


	@Override
	public List<CommentaireBlog> findByClient(Long client) {
		return commentaireBlogRepo.findByClient(client);
	}

}
