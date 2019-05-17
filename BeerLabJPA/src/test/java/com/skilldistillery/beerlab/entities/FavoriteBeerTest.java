package com.skilldistillery.beerlab.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FavoriteBeerTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private FavoriteBeer favBeer;

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
		favBeer = em.find(FavoriteBeer.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		favBeer = null;
	}

	@Test
	void test_Brewery_Mapping() {
		assertEquals(1, favBeer.getDrinker().getId());
		//assertEquals(1, favBeer.getBeerId());
		assertEquals("2038-01-19", favBeer.getDateAdded().toString());
	}
	
	@Test
	void test_FavBeer_ManyToOne_With_Beer() {
		assertEquals("The IPA", favBeer.getBeer().getName());
	}

}
