package be.shop.service;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import be.shop.entity.Achat;
import be.shop.entity.Client;

@Local
public interface AchatServices {

	List<Achat> findByDate(Date date);

	List<Achat> findByClient(Client client);
}
