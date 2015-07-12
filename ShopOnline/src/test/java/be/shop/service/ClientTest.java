package be.shop.service;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import be.shop.entity.Client;
import be.shop.repository.ClientRepository;
import be.shop.service.impl.ClientServicesImpl;

public class ClientTest {

	private ClientRepository clientRepository = null;
	private ClientServicesImpl clientService = null;

	@Before
	public void setUp() {
		clientRepository = createMock(ClientRepository.class);
		clientService = new ClientServicesImpl();
		clientService.setClientRepository(clientRepository);
	}

	@Test
	public void testLoginClientUnknown() {
		Client client = new Client();
		client.setEmail("myEmail@live.net");
		client.setPassword("myPassword");
		expect(
				clientRepository.findByEmailPassword("myWrongEmail@live.net",
						"myPassword")).andReturn(null);
		replay(clientRepository);
		assertNull(clientService.loginClient("myWrongEmail@live.net",
				"myPassword"));
		verify(clientRepository);

	}

	@Test
	public void testLoginClientSuccess() {
		Client client = new Client();
		client.setEmail("adresseEmail@live.net");
		client.setPassword("passwordclient");
		expect(
				clientRepository.findByEmailPassword("adresseEmail@live.net",
						"passwordclient")).andReturn(client);
		replay(clientRepository);
		assertEquals(clientService.loginClient("adresseEmail@live.net",
				"passwordclient"), client);
		verify(clientRepository);
	}

	@Test
	public void testRegister() {
		Client client = new Client();
		client.setEmail("monEmail@live.net");
		clientRepository.save(client);
		expect(clientRepository.findByEmail("monEmail@live.net")).andReturn(
				client);
		replay(clientRepository);
		clientService.registerClient(client);
		assertEquals("monEmail@live.net", client.getEmail());
		assertEquals(clientRepository.findByEmail("monEmail@live.net"), client);
		// la méthode verify permet vérifier que toutes les méthodes ont été
		// bien appelées
		verify(clientRepository);
	}
}
