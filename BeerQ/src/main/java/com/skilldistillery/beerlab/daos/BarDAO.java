package com.skilldistillery.beerlab.daos;

import com.skilldistillery.beerlab.entities.Bar;

public interface BarDAO {
	// Create
	public Bar createBar(Bar bar);

	// Read
	public int findBarName(String barName);

	// Update
	public Bar updateBar(int id, Bar bar);

	// Destroy
	public boolean destroyBar(int id);

}
