package be.shop.service;

import java.util.List;

import javax.ejb.Local;

import be.shop.entity.Blog;

@Local
public interface BlogServices {

	List<Blog> findByTitre(String titre);
}
