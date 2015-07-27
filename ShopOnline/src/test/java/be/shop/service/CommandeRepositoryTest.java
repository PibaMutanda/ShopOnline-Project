package be.shop.service;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import be.shop.entity.Achat;
import be.shop.entity.Commande;
import be.shop.repository.CommandeRepository;
import be.shop.service.impl.CommandeServicesImpl;

public class CommandeRepositoryTest {

	private CommandeRepository commandeRepository = null;
	
	private CommandeServicesImpl commandeServicesImpl = null;
	
	@Before
	public void setUp() throws Exception {
		commandeRepository = createMock(CommandeRepository.class);
		commandeServicesImpl = new CommandeServicesImpl();
		commandeServicesImpl.setCommandeRepository(commandeRepository);
	}

	@Test
	@Ignore
	public void testFindByAchat() {
		Achat achatOrdi = new Achat();
		Achat achatCasque = new Achat();
		Achat achaMontre = new Achat();
		Commande commande = new Commande();
		commande.addAchat(achatCasque);
		
	}

	@Test
	@Ignore
	public void testFindByArticle() {
		fail("Not yet implemented");
	}

}
