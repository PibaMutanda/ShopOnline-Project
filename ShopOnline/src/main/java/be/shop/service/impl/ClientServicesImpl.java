package be.shop.service.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.shop.entity.Client;
import be.shop.repository.ClientRepository;
import be.shop.service.ClientServices;

@Stateless
public class ClientServicesImpl implements ClientServices {

	
	@EJB(name="clientRepository")
	private ClientRepository clientRepository;
	
	public void setClientRepository(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public Client loginClient(String email, String passwd) {	
		return clientRepository.findByEmailPassword(email, passwd);
	}

	@Override
	public void registerClient(Client client) {     
		  clientRepository.save(client);
	}

}
