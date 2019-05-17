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

class BarOwnerTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private BarOwner barOwner;

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
		barOwner = em.find(BarOwner.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		barOwner = null;
	}

	@Test
	void test_brewery_mapping() {
		assertEquals(1, barOwner.getBarId());
		assertEquals(1, barOwner.getUserId());
	}

}
