/**
 * 
 */
package be.shop.repository;

import javax.ejb.Local;

import be.shop.entity.Blog;

/**
 * @author P. Mutanda
 *
 */
@Local
public interface BlogRepository extends GenericRepository<Blog> {

}
