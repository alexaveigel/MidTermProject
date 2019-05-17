package com.skilldistillery.beerlab.daos;

import java.util.List;

import com.skilldistillery.beerlab.entities.Bar;

public interface BarDAO {
	// Create
	public Bar createBar(Bar bar);

	// Read
	public int findBarByName(String barName);
	
	public int findBarByCity(String city);
	
	public List<Bar> findAllBars();

	// Update
	public Bar updateBar(int id, Bar bar);

	// Destroy
	public boolean destroyBar(int id);

}
