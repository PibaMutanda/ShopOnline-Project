package be.shop.repository;

import java.util.List;

import javax.ejb.Local;

import be.shop.entity.Article;

@Local
public interface ArticleRepository extends GenericRepository<Article> {

	List<Article> findByCateg(Long id);
}
