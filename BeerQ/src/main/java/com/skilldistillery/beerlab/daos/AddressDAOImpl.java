package com.skilldistillery.beerlab.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.beerlab.entities.Address;

public class AddressDAOImpl implements AddressDAO {

	private static EntityManagerFactory emf;
	private EntityManager em;

	static {
		emf = Persistence.createEntityManagerFactory("BeerQ");
	}

	@Override
	public Address createAddress(Address address) {
		em = emf.createEntityManager();

		// start the transaction
		em.getTransaction().begin();
		// write the address to the database
		em.persist(address);
		// update the "local" address object
		em.flush();
		// commit the changes (actually perform the operation)
		em.getTransaction().commit();

		em.close();
		// return the address object
		return address;
	}

	@Override
	public Address updateAddress(int id, Address address) {
		EntityManager em = emf.createEntityManager();
		// open a transaction
		em.getTransaction().begin();

		// retrieve a "managed" Address entity
		Address updatedAddress = em.find(Address.class, id);

		// update the values of the detached entity
		updatedAddress.setStreet(address.getStreet());
		updatedAddress.setCity(address.getCity());
		updatedAddress.setZip(address.getZip());
		updatedAddress.setCountry(address.getCountry());
		updatedAddress.setLatitude(address.getLatitude());
		updatedAddress.setLongitude(address.getLongitude());
		
		
		em.getTransaction().commit();
		em.close();
		return updatedAddress;
	}



	@Override
	public boolean destroyAddress(int addressId) {
		boolean itWorked = false;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Address destroyedAddress = em.find(Address.class, addressId);
		em.remove(destroyedAddress);
		em.getTransaction().commit();
		itWorked = true;
	
		return itWorked;
	}



}
