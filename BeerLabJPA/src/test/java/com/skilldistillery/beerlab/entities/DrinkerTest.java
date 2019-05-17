package com.skilldistillery.beerlab.entities;

import static org.junit.jupiter.api.Assertions.fail;

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
	void test() {
		fail("Not yet implemented");
	}

}
