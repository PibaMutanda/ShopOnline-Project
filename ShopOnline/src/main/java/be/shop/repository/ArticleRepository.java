package be.shop.repository;

import javax.ejb.Local;

import be.shop.entity.Article;

@Local
public interface ArticleRepository extends GenericRepository<Article> {

}
