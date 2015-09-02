package be.shop.repository;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import be.shop.entity.Achat;
import be.shop.entity.Client;
import be.shop.entity.Commande;

@Local
public interface CommandeRepository extends GenericRepository<Commande> {

	List<Commande> findByAchat(Achat achat);

	List<Commande> findByArticle(Long article);
	
	List<Commande> findByClientAndDate(Client client, Date dateCommande);
	
	List<Commande> findAllWithoutPurchase();
	
	List<Commande> findTenPurchaseOfClient(Client client);
}
