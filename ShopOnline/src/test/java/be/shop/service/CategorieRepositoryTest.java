package be.shop.service;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import be.shop.entity.Categorie;
import be.shop.repository.CategorieRepository;
import be.shop.service.impl.CategorieServicesImpl;

public class CategorieRepositoryTest {

	private CategorieRepository categorieRepository=null;
	private CategorieServicesImpl categorieServicesImpl=null;
	
	@Before
	public void setUp() throws Exception {
		categorieRepository = createMock(CategorieRepository.class);
		categorieServicesImpl = new CategorieServicesImpl();
		categorieServicesImpl.setCategorieRepository(categorieRepository);
	}

	@Test
	public void testFindAll() {
		List<Categorie> categories = new ArrayList<Categorie>();
		Categorie categorie = new Categorie();
		Categorie categorie2 = new Categorie(); categorie2.setNom("HI-FI");
		Categorie categorie3 = new Categorie();
		categories.add(categorie3); categories.add(categorie2);   categories.add(categorie);
		expect(categorieRepository.findAll()).andReturn(categories);
		replay(categorieRepository);
		assertEquals(3, categorieServicesImpl.findAll().size());
		verify(categorieRepository);
		
	}
	
	@Test
	public void testFindById(){
		Categorie categorie=new Categorie();
		categorieRepository.save(categorie);
		expect(categorieRepository.findById(1l)).andReturn(categorie);
		replay(categorieRepository);
		assertEquals(categorie, categorieServicesImpl.findById(1l));
	
	}
	
	@Test
	public void testFindByName(){
		Categorie categorie = new Categorie();
		Categorie categorie2 = new Categorie();
		categorie.setNom("HI-FI");
		categorie2.setNom("LIVRE");
		categorieRepository.save(categorie);
		categorieRepository.save(categorie2);
		
		expect(categorieRepository.findByName("HI-FI")).andReturn(categorie);
		replay(categorieRepository);
		assertEquals(categorie, categorieServicesImpl.findByName("HI-FI"));
		
		
//		expect(categorieRepository.findByName("LIVRE")).andReturn(categorie2);
//		replay(categorieRepository);
//		assertEquals(categorie2, categorieServicesImpl.findByName("LIVRE"));
	}

}
