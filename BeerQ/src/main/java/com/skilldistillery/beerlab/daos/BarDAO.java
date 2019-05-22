package com.skilldistillery.beerlab.daos;

import java.util.List;

import com.skilldistillery.beerlab.entities.Bar;
import com.skilldistillery.beerlab.entities.Beer;

public interface BarDAO {
	// Create
	public Bar createBar(Bar bar);

	// Read
	public List<Bar> findBarByName(String barName);
	
	public List<Bar> findBarByCity(String city);
	
	public List<Bar> findAllBars();

	// Update
	public Bar updateBar(int id, Bar bar);

	// Destroy
	public boolean destroyBar(int id);

	Bar findBarById(int barId);
	
	public void addBeerToBarInventory(Beer beer, Bar bar);
}
