package be.shop.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.shop.entity.Article;
import be.shop.entity.Categorie;
import be.shop.repository.ArticleRepository;
import be.shop.service.ArticleServices;

@Stateless
public class ArticleServicesImpl implements ArticleServices {

	@EJB(name="articleRepository")
	private ArticleRepository articleRepository;
	
	
	public void setArticleRepository(ArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}


	@Override
	public List<Article> findByCateg(Categorie categorie) {
		return articleRepository.findByCateg(categorie);
	}

}
