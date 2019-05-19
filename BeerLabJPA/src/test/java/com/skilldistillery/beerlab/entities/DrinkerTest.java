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

class DrinkerTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Drinker drinker;

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
		drinker = em.find(Drinker.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		drinker = null;
	}

	@Test
	void test_drinker_mapping() {
		assertEquals("The", drinker.getFirstName());
		assertEquals("Drinker", drinker.getLastName());
		assertEquals("1995-01-30", drinker.getDob().toString());
		assertEquals("Girl", drinker.getGender());
		assertEquals("IPA", drinker.getBeerStyle());
		assertEquals("pic.com", drinker.getPicUrl());
		assertEquals(1, drinker.getAddressId());
	}
	
	@Test
	void test_drinker_to_favorite_beer_mapping() {
		assertEquals("No comment", drinker.getFavBeer().get(0).getComment());
	}
	
	@Test
	void test_drinker_to_user_mapping() {
		assertEquals(1, drinker.getUser().getId());
	}
	
	

}
