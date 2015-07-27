package be.shop.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.shop.entity.Blog;
import be.shop.repository.BlogRepository;
import be.shop.service.BlogServices;

@Stateless
public class BlogServicesImpl implements BlogServices {

	@EJB(name="blogRepository")
	private BlogRepository blogRepository;
	
	
	
	public void setBlogRepository(BlogRepository blogRepository) {
		this.blogRepository = blogRepository;
	}



	@Override
	public List<Blog> findByTitre(String titre) {
		return blogRepository.findByTitre(titre);
	}

}
