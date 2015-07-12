package be.shop.service;

import javax.ejb.Local;

import be.shop.entity.Client;

@Local
public interface ClientServices {

	Client loginClient(String email, String passwd);

	void registerClient(Client client);
}
