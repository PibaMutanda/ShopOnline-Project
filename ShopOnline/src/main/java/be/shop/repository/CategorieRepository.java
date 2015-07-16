/**
 * 
 */
package be.shop.repository;

import javax.ejb.Local;

import be.shop.entity.Categorie;

/**
 * @author P. Mutanda
 *
 */
@Local
public interface CategorieRepository extends GenericRepository<Categorie> {
      Categorie findByName(String name);
}
