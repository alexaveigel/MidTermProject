package com.skilldistillery.beerlab.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BeerTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Beer beer;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("BeerQ");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		beer = em.find(Beer.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		beer = null;
	}
	
	@Test
	public void test_Beer_Mapping_Correct() {
		assertEquals(1, beer.getId());
		assertEquals("IPA", beer.getStyle());
		assertEquals("The IPA", beer.getName());
		assertEquals(7.8, beer.getAbv());
		//assertEquals(1, beer.getBreweryId());
		assertEquals("hoppy", beer.getDescription());
	}
	
	@Test
	void test_bar_to_beer_mapping() {
		assertEquals(1, beer.getBars().get(0).getId());
	}
		
	@Test	
	public void test_Beer_ManyToOne_With_Brewery() {
		assertEquals("The Brewery" , beer.getBrewery().getName());
	}
	
	@Test
	public void test_Beer_ManyToOne_With_FavBeer() {
		assertEquals("No comment", beer.getListFavBeers().get(0).getComment());
	}
	

}
