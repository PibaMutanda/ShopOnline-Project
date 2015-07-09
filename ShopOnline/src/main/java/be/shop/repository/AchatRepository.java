/**
 * 
 */
package be.shop.repository;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import be.shop.entity.Achat;
import be.shop.entity.Client;

/**
 * @author P. Mutanda
 *
 */
@Local
public interface AchatRepository extends GenericRepository<Achat> {

	List<Achat> findByDate(Date date);

	List<Achat> findByClient(Client client);
}
