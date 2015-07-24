package be.shop.repository;

import java.util.List;

import javax.ejb.Local;

import be.shop.entity.Article;
import be.shop.entity.Categorie;

@Local
public interface ArticleRepository extends GenericRepository<Article> {

	List<Article> findByCateg(Categorie categorie);
}
