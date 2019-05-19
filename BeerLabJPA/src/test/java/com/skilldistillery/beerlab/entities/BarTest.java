package com.skilldistillery.beerlab.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BarTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Bar bar;

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
		bar = em.find(Bar.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		bar = null;
	}
	@Test
	void test_bar_mapping() {
		assertEquals("Denver", bar.getAddress().getCity());
		assertEquals("The Bar", bar.getName());
		assertEquals("a message", bar.getMessage());
		assertEquals("url.com", bar.getWebUrl());
		assertEquals("logo.com", bar.getLogoUrl());
	}
	
	@Test
	void test_Bar_OneToOne_Unidirectional_With_Address() {
		bar = em.find(Bar.class, 1);
		Address address = bar.getAddress();
		assertEquals("123 Test Street", address.getStreet());
	}

	@Test
	void test_bar_to_user_mapping() {
		assertEquals(1, bar.getBeers().get(0).getId());
	}
	
	@Test
	void test_bar_to_beer_mapping() {
		//assertEquals(1, bar.getBeers().get(0).getId());
		assertNotNull(bar.getBeers());
		System.out.println(bar.getBeers());
		
	}
	
}
