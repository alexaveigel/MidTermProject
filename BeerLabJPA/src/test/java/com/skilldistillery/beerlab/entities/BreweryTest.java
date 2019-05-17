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

class BreweryTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Brewery brewery;

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
		brewery = em.find(Brewery.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		brewery = null;
	}

	@Test
	void test_brewery_mapping() {
		//assertEquals(1, brewery.getAddressId());
		assertEquals("The Brewery", brewery.getName());
		assertEquals("web.com", brewery.getWebUrl());
		assertEquals("logo.com", brewery.getLogoUrl());
	}
	
	@Test
	void test_Brewery_OneToOne_Unidirectional_With_Address() {
		brewery = em.find(Brewery.class, 1);
		Address address = brewery.getAddress();
		assertEquals("123 Test street", address.getStreet());
	}
}
