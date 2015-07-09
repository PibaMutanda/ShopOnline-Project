package be.shop.repository;

import java.util.List;

import javax.ejb.Local;

import be.shop.entity.Commande;

@Local
public interface CommandeRepository extends GenericRepository<Commande> {

	List<Commande> findByAchat(Long idAchat);

	List<Commande> findByArticle(Long idArticle);
}
