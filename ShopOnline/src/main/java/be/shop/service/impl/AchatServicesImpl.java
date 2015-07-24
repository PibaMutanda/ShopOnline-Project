package be.shop.service.impl;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.shop.entity.Achat;
import be.shop.entity.Client;
import be.shop.repository.AchatRepository;
import be.shop.service.AchatServices;


@Stateless
public class AchatServicesImpl implements AchatServices {

	@EJB(name="achatRepository")
	private AchatRepository achatRepository;
	
	public void setAchatRepository(AchatRepository achatRepository) {
		this.achatRepository = achatRepository;
	}

	@Override
	public List<Achat> findByDate(Date date) {
		return achatRepository.findByDate(date);
	}

	@Override
	public List<Achat> findByClient(Client client) {

		return achatRepository.findByClient(client);
	}

}
