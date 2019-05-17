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

class AddressTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Address address;
	

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
		address = em.find(Address.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		address = null;
	}
	
	@Test
	public void test_Address_Mapping_Correct() {
		assertEquals(1, address.getId());
		assertEquals("123 Test street", address.getStreet());
		assertEquals("Denver", address.getCity());
		assertEquals("80216", address.getZip());
		assertEquals("123.456", address.getLatitude());
		assertEquals("654.321", address.getLongitude());
	}
	
	
	

}
