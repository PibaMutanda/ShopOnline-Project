/**
 * 
 */
package be.shop.repository;

import javax.ejb.Local;

import be.shop.entity.Client;

/**
 * @author P. Mutanda
 *
 */
@Local
public interface ClientRepository extends GenericRepository<Client> {

}
