package be.shop.service;

import java.util.List;

import javax.ejb.Local;

import be.shop.entity.Article;
import be.shop.entity.Categorie;

@Local
public interface ArticleServices {

	List<Article> findByCateg(Categorie categ);
}
