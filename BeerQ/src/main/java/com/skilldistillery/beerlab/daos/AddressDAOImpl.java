package com.skilldistillery.beerlab.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.beerlab.entities.Address;

@Service
@Transactional
public class AddressDAOImpl implements AddressDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Address createAddress(Address address) {

		// write the address to the database
		em.persist(address);
		// update the "local" address object
		em.flush();

		// return the address object
		return address;
	}

	@Override
	public Address updateAddress(int id, Address address) {
		// open a transaction

		// retrieve a "managed" Address entity
		Address updatedAddress = em.find(Address.class, id);

		// update the values of the detached entity
		updatedAddress.setStreet(address.getStreet());
		updatedAddress.setState(address.getState());
		updatedAddress.setCity(address.getCity());
		updatedAddress.setZip(address.getZip());
		updatedAddress.setCountry(address.getCountry());
		updatedAddress.setLatitude(address.getLatitude());
		updatedAddress.setLongitude(address.getLongitude());

		return updatedAddress;
	}

	@Override
	public boolean destroyAddress(int addressId) {
		boolean itWorked = false;

		Address destroyedAddress = em.find(Address.class, addressId);
		em.remove(destroyedAddress);
		itWorked = true;

		return itWorked;
	}

}
