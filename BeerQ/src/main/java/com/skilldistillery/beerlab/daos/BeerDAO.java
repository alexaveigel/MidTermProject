package com.skilldistillery.beerlab.daos;

import java.util.List;

import com.skilldistillery.beerlab.entities.Beer;
import com.skilldistillery.beerlab.entities.Brewery;
import com.skilldistillery.beerlab.entities.FavoriteBeer;
import com.skilldistillery.beerlab.entities.User;

public interface BeerDAO {
	// Create
	public Beer createBeer(Beer beer);

	public List<FavoriteBeer> addBeerToFavList(Beer beer, User user);

	public List<FavoriteBeer> getListOfFavBeer(User user);

	// Read
	public List<Brewery> getBreweries();
	
	public List<Beer> getSixPack();
	
	public List<String> getStyles();
	
	public List<Beer> getBeerByStyle(String style);
	
	public List<Beer> getBeerByABV(double minAbv, double maxAbv);
	
	public List<Beer> findBeerByName(String beerName);

	public List<Beer> findBeerByBrewery(String brewery);

	public List<Beer> findBeerByCity(String city);

	public List<Beer> findAllBeers();

	public List<Beer> approved();

	public List<Beer> approveBeer(Beer beer);
	// Update
	public Beer updateBeer(int id, Beer beer);

	// Destroy
	public boolean destroyBeer(int id);

	List<Beer> unapproved();
	
	Beer findBeerById(int beerId);
		
	

}
