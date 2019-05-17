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
		assertEquals(1, bar.getAddressId());
		assertEquals("The Bar", bar.getName());
		assertEquals("a message", bar.getMessage());
		assertEquals("url.com", bar.getWebUrl());
		assertEquals("logo.com", bar.getLogoUrl());
	}

}
