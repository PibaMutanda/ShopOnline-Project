package be.shop.service.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.shop.entity.Achat;
import be.shop.entity.Commande;
import be.shop.repository.CommandeRepository;
import be.shop.service.CommandeServices;

@Stateless
public class CommandeServicesImpl implements CommandeServices {

	@EJB(name="commandeRepository")
	private CommandeRepository commandeRepository;
	
	
	

	public void setCommandeRepository(CommandeRepository commandeRepository) {
		this.commandeRepository = commandeRepository;
	}

	@Override
	public List<Commande> findByAchat(Achat achat) {
		return commandeRepository.findByAchat(achat);
	}

	@Override
	public List<Commande> findByArticle(Long idArticle) {
	
		return commandeRepository.findByArticle(idArticle);
	}

}
