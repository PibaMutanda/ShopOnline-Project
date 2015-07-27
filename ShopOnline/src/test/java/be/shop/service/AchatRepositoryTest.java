package be.shop.service;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import be.shop.entity.Achat;
import be.shop.entity.Client;
import be.shop.repository.AchatRepository;
import be.shop.service.impl.AchatServicesImpl;

public class AchatRepositoryTest {

	private AchatRepository achatRepository = null;

	private AchatServicesImpl achatServiceImpl = null;

	@Before
	public void setUp() throws Exception {
		achatRepository = createMock(AchatRepository.class);
		achatServiceImpl = new AchatServicesImpl();
		achatServiceImpl.setAchatRepository(achatRepository);
	}

	@Test
	public void testFindByDate() {
		List<Achat> achats = new ArrayList<Achat>();
		Achat achat1 = new Achat();
		Achat achat2 = new Achat();
		Date d = new Date();
		achat1.setDateAchat(d);
		achat2.setDateAchat(d);
		achats.add(achat1);
		achats.add(achat2);
		achatRepository.save(achat2);     achatRepository.save(achat1);   
		
		expect(achatRepository.findByDate(d)).andReturn(achats).times(2);
		replay(achatRepository);
		assertEquals(achatServiceImpl.findByDate(d).get(0), achat1);
		assertEquals(achatServiceImpl.findByDate(d).size(), 2);
	}

	@Test
	public void testFindByClient() {
		List<Achat> achatCli1 = new ArrayList<Achat>();
		List<Achat> achatCli2 = new ArrayList<Achat>();
		Achat achat1 = new Achat();
		Achat achat2 = new Achat();
		Achat achat3 = new Achat();
		achatCli1.add(achat1);
		achatCli1.add(achat2);
		achatCli2.add(achat3);
		Client client1 = new Client();
		Client client2 = new Client();
		achat1.setClient(client1);
		achat2.setClient(client1);
		achat3.setClient(client2);
		achatRepository.save(achat3);    achatRepository.save(achat2);    achatRepository.save(achat1);
		expect(achatRepository.findByClient(client1)).andReturn(achatCli1)
				.anyTimes();
		expect(achatRepository.findByClient(client2)).andReturn(achatCli2);
		replay(achatRepository);
		assertEquals(achatServiceImpl.findByClient(client2), achatCli2);
		assertEquals(achatServiceImpl.findByClient(client1).size(), 2);

	}

}
