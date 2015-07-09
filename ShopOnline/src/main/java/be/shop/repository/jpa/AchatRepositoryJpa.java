package be.shop.repository.jpa;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import be.shop.entity.Achat;
import be.shop.entity.Client;
import be.shop.repository.AchatRepository;

@Stateless
public class AchatRepositoryJpa extends GenericRepositoryJpa<Achat> implements
		AchatRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Achat> findByDate(Date date) {
		List<Achat> resultList = entityManager
				.createNamedQuery("Achat.findByDate")
				.setParameter("date", date).getResultList();
		return resultList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Achat> findByClient(Client client) {
		return getEntityManager().createNamedQuery("Achat.findByClient")
				.setParameter("client", client).getResultList();
	}

}
