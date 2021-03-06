package com.skilldistillery.beerlab.daos;

import com.skilldistillery.beerlab.entities.Address;

public interface AddressDAO {
	// Create
	public Address createAddress(Address address);

	// Update
	public Address updateAddress(int id, Address Address);

	// Destroy
	public boolean destroyAddress(int addressId);

}
