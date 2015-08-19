package be.shop.service;

import java.util.List;

import javax.ejb.Local;

import be.shop.entity.Article;
import be.shop.entity.Categorie;
import be.shop.entity.Commande;

@Local
public interface ArticleServices {

	List<Article> findByCateg(Categorie categ);
	
	List<Article> findByCommande(Commande commande);
}
