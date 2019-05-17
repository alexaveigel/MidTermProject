package com.skilldistillery.beerlab.daos;

import java.util.List;

import com.skilldistillery.beerlab.entities.Beer;

public interface BeerDAO {
	// Create
	public Beer createBeer(Beer beer);

	// Read
	public int findBeerByName(String beerName);
	
	public int findBeerByBrewery(String brewery);

	public int findBeerByCity(String city);

	public List<Beer> findAllBeers();
	
	// Update
	public Beer updateBeer(int id, Beer beer);

	// Destroy
	public boolean destroyBeer(int id);

}
