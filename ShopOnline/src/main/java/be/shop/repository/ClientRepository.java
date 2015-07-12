/**
 * 
 */
package be.shop.repository;

import java.util.Date;

import javax.ejb.Local;

import be.shop.entity.Client;

/**
 * @author P. Mutanda
 *
 */
@Local
public interface ClientRepository extends GenericRepository<Client> {

	Client findByEmail(String email);

	Client findByDateInscr(Date date);
	
	Client findByEmailPassword(String email,String password);
}
