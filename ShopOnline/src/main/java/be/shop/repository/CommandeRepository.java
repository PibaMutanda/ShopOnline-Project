package be.shop.repository;

import javax.ejb.Local;

import be.shop.entity.Commande;

@Local
public interface CommandeRepository extends GenericRepository<Commande> {

}
