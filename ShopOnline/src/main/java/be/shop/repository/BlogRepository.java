/**
 * 
 */
package be.shop.repository;

import java.util.List;

import javax.ejb.Local;

import be.shop.entity.Blog;

/**
 * @author P. Mutanda
 *
 */
@Local
public interface BlogRepository extends GenericRepository<Blog> {

	List<Blog> findByTitre(String titre);
}
