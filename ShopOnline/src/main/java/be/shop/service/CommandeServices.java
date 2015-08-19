package be.shop.service;

import java.util.List;

import javax.ejb.Local;

import be.shop.entity.Achat;
import be.shop.entity.Commande;

@Local
public interface CommandeServices {

	List<Commande> findByAchat(Achat achat);
	
	List<Commande> findByArticle(Long article);
}
