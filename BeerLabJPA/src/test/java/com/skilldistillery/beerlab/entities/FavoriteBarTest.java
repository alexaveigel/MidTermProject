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

class FavoriteBarTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private FavoriteBar favBar;
	

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
		favBar = em.find(FavoriteBar.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		favBar = null;
	}
	
	public void test_Favorite_Bar_Mapping_Correct() {
		assertEquals(1, favBar.getId());
		assertEquals(1, favBar.getBarId());
		assertEquals(05/19, favBar.getDateAdded());
		assertEquals("Comment", favBar.getComment());		
	}

	
	
}
