package be.shop.repository.jpa;

import java.util.List;

import javax.ejb.Stateless;

import be.shop.entity.Achat;
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
	public List<Commande> findByArticle(Long idArticle) {
		return getEntityManager().createNamedQuery("Commande.findByArticle")
				.setParameter("id", idArticle).getResultList();
	}

}
