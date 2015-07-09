package be.shop.repository.jpa;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import be.shop.entity.Client;
import be.shop.repository.ClientRepository;

/**
 * Session Bean implementation class ClientRepositoryJpa
 */
@Stateless
public class ClientRepositoryJpa extends GenericRepositoryJpa<Client> implements
		ClientRepository {

	@SuppressWarnings("unchecked")
	@Override
	public Client findByEmail(String email) {
		Client client = null;
		List<Client> clients = getEntityManager()
				.createNamedQuery("Client.findByEmail")
				.setParameter("email", email).getResultList();
		if (!clients.isEmpty())
			client = clients.get(0);
		return client;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Client findByDateInscr(Date date) {
		Client client = null;
		List<Client> clients = getEntityManager()
				.createNamedQuery("Client.findByDateInscr")
				.setParameter("date", date).getResultList();
		if (!clients.isEmpty())
			client = clients.get(0);
		return client;
	}

}
