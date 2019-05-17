package com.skilldistillery.beerlab.daos;

import com.skilldistillery.beerlab.entities.Beer;

public interface BeerDAO {
	// Create
	public Beer createBeer(Beer beer);

	// Read
	public int findBeerName(String beerName);

	// Update
	public Beer updateBeer(int id, Beer beer);

	// Destroy
	public boolean destroyBeer(int id);

}
