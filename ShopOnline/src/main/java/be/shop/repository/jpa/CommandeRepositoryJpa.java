package be.shop.repository.jpa;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import be.shop.entity.Achat;
import be.shop.entity.Client;
import be.shop.entity.Commande;
import be.shop.repository.CommandeRepository;

/**
 * Session Bean implementation class CommandeRepositoryJpa
 */
@Stateless
public class CommandeRepositoryJpa extends GenericRepositoryJpa<Commande>
		implements CommandeRepository {

	@SuppressWarnings("unchecked")
	@Override
	public List<Commande> findByAchat(Achat achat) {
		return getEntityManager().createNamedQuery("Commande.findByAchat")
				.setParameter("achat", achat).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commande> findByArticle(Long article) {
		return getEntityManager().createNamedQuery("Commande.findByArticle")
				.setParameter("article", article).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commande> findByClientAndDate(Client client, Date dateCommande) {
		return getEntityManager()
				.createNamedQuery("Commande.findByClientAndDate")
				.setParameter("client", client)
				.setParameter("dateCommande", dateCommande).getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commande> findAllWithoutPurchase() {
		return getEntityManager().createNamedQuery(
				"Commande.findAllWithoutPurchase").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Commande> findTenPurchaseOfClient(Client client) {
		return getEntityManager()
				.createNamedQuery("Commande.findTenPurchaseOfClient")
				.setMaxResults(10)
				.setParameter("client", client).getResultList();
	}

}
