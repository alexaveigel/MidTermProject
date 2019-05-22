package com.skilldistillery.beerlab.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.beerlab.entities.Address;
import com.skilldistillery.beerlab.entities.Bar;
import com.skilldistillery.beerlab.entities.Beer;

@Service
@Transactional
public class BarDAOImpl implements BarDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Bar createBar(Bar bar) {

		// write the bar to the database
		em.persist(bar);
		// update the "local" bar object
		em.flush();

		// return the address object
		return bar;
	}

	@Override
	public Bar updateBar(int id, Bar bar) {

		// retrieve a "managed" Bar entity
		Bar updatedBar = em.find(Bar.class, id);
		Address address = bar.getAddress();
		Address updateAddress = em.find(Address.class, address.getId());
		// update the values of the detached entity
		updatedBar.setName(bar.getName());
		updatedBar.setMessage(bar.getMessage());
		updatedBar.setAddress(updateAddress);
		updatedBar.setWebUrl(bar.getWebUrl());
		updatedBar.setLogoUrl(bar.getLogoUrl());
		updatedBar.setBeers(bar.getBeers());
		System.out.println(updatedBar.getBeers());
		return updatedBar;
	}

	public void addBeerToBarInventory(Beer beer, Bar bar) {

		String query = "INSERT into bar_inventory (bar_id, beer_id) VALUES (:barId, :beerId)";

		em.createNativeQuery(query).setParameter("barId", bar.getId()).setParameter("beerId", beer.getId())
				.executeUpdate();

	}

	@Override
	public List<Bar> findBarByName(String barName) {

		String query = "SELECT bar FROM Bar bar WHERE bar.name LIKE :barName";
		List<Bar> bars = em.createQuery(query, Bar.class).setParameter("barName", "%" + barName + "%").getResultList();

		return bars;
	}

	@Override
	public List<Bar> findBarByCity(String city) {
		String query = "SELECT bar FROM Bar bar WHERE bar.address.city = :city";
		List<Bar> cities = em.createQuery(query, Bar.class).setParameter("city", city).getResultList();
		return cities;
	}

	@Override
	public List<Bar> findAllBars() {
		String query = "SELECT b FROM Bar b";
		List<Bar> bars = em.createQuery(query, Bar.class).getResultList();

		for (Bar bar : bars) {
			System.out.println("In bar dao: " + bar);
		}
		return bars;
	}

	@Override
	public boolean destroyBar(int barId) {
		boolean itWorked = false;

		Bar destroyedBar = em.find(Bar.class, barId);
		em.remove(destroyedBar);
		itWorked = true;

		return itWorked;
	}

	@Override
	public Bar findBarById(int barId) {
		Bar bar = em.find(Bar.class, barId);
		return bar;
	}

}
