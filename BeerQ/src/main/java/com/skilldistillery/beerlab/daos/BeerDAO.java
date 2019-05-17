package com.skilldistillery.beerlab.daos;

import java.util.List;

import com.skilldistillery.beerlab.entities.Beer;

public interface BeerDAO {
	// Create
	public Beer createBeer(Beer beer);

	// Read
	public List<Beer>  findBeerByName(String beerName);
	
	public List<Beer>  findBeerByBrewery(String brewery);

	public List<Beer>  findBeerByCity(String city);

	public List<Beer> findAllBeers();
	
	// Update
	public Beer updateBeer(int id, Beer beer);

	// Destroy
	public boolean destroyBeer(int id);

}
