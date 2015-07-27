package be.shop.service;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import be.shop.entity.Blog;
import be.shop.repository.BlogRepository;
import be.shop.service.impl.BlogServicesImpl;

public class BlogRepositoryTest {

	private BlogRepository blogRepository=null;
	
	private BlogServicesImpl blogServiceImpl=null;
	
	@Before
	public void setUp() throws Exception {
		blogRepository=createMock(BlogRepository.class);
		blogServiceImpl = new BlogServicesImpl();
		blogServiceImpl.setBlogRepository(blogRepository);
	}

	@Test
	public void testFindByTitre() {
		Blog blog1 = new Blog();
		Blog blog2 = new Blog();
		Blog blog3 = new Blog();
		List<Blog>blogs = new ArrayList<Blog>();
		blogs.add(blog1);
		blogs.add(blog2);
		blogs.add(blog3);
		blog1.setTitre("Arriva de iphone 4");
		blog2.setTitre("Samgung plus vendus que iphone !!  que pensez-vous ?");
		blog3.setTitre("Les livres en informatique en englais sont mieux qu'en français ");
		blogRepository.save(blog3);
		blogRepository.save(blog2);
		blogRepository.save(blog1);
		expect(blogRepository.findByTitre("iphone")).andReturn(blogs).times(2);
		replay(blogRepository);
		List blogs2 = blogServiceImpl.findByTitre("iphone");

		assertEquals(blogServiceImpl.findByTitre("iphone"), blogs2);
	}

}
