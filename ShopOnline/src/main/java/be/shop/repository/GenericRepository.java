/**
 * 
 */
package be.shop.repository;

import java.util.List;

/**
 * @author P. Mutanda
 * 
 *         Interface générique pour partager les mêmes méthodes entre chaque
 *         session bean
 */
public interface GenericRepository<T> {

	T findById(Long id);

	List<T> findAll();

	void save(T t);

	void delete(T t);

	void delete(Long id);
}
