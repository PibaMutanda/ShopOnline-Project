package be.shop.service;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import be.shop.entity.Article;
import be.shop.entity.Categorie;
import be.shop.repository.ArticleRepository;
import be.shop.service.impl.ArticleServicesImpl;

public class ArticleRepositoryTest {

	private ArticleRepository articleRepository = null;
	private ArticleServicesImpl articleServiceImpl=null;

	@Before
	public void setUp() throws Exception {
		
		articleRepository = createMock(ArticleRepository.class);
		articleServiceImpl = new ArticleServicesImpl();
		articleServiceImpl.setArticleRepository(articleRepository);
	}

	@Test
	public void testFindByCateg() {
		List<Article>listArt = new ArrayList<Article>();
		Article article1 = new Article();
		Article article2 = new Article();
		article1.setDenomination("Livre Java");
		Categorie categorie = new  Categorie();
		article1.setCateg(categorie);
		article2.setCateg(categorie);
		listArt.add(article1);   listArt.add(article2);
		articleRepository.save(article2);    articleRepository.save(article1);
		expect(articleRepository.findByCateg(categorie)).andReturn(listArt).times(3);
		replay(articleRepository);
		assertEquals(articleServiceImpl.findByCateg(categorie).get(1), article2);
		assertEquals(articleServiceImpl.findByCateg(categorie), listArt);
		assertEquals(articleServiceImpl.findByCateg(categorie).get(0).getDenomination(), "Livre Java");
		
	}

}
