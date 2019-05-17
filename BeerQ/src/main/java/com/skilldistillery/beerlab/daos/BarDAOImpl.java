package com.skilldistillery.beerlab.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.beerlab.entities.Bar;

public class BarDAOImpl implements BarDAO {
	
	private static EntityManagerFactory emf;
	private EntityManager em;

	static {
		emf = Persistence.createEntityManagerFactory("BeerQ");
	}

	@Override
	public Bar createBar(Bar bar) {
		em = emf.createEntityManager();

		// start the transaction
		em.getTransaction().begin();
		// write the bar to the database
		em.persist(bar);
		// update the "local" bar object
		em.flush();
		// commit the changes (actually perform the operation)
		em.getTransaction().commit();

		em.close();
		// return the address object
		return bar;
	}

	@Override
	public Bar updateBar(int id, Bar bar) {
		emf.createEntityManager();
		// open a transaction
		em.getTransaction().begin();

		// retrieve a "managed" Bar entity
		Bar updatedBar = em.find(Bar.class, id);

		// update the values of the detached entity
		updatedBar.setName(bar.getName());
		updatedBar.setMessage(bar.getMessage());
		updatedBar.setAddress(bar.getAddress());
		updatedBar.setWebUrl(bar.getWebUrl());
		updatedBar.setLogoUrl(bar.getLogoUrl());
		
		
		em.getTransaction().commit();
		em.close();
		return updatedBar;
	}

	@Override
	public int findBarByName(String barName) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int findBarByCity(String city) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean destroyBar(int barId) {
		boolean itWorked = false;
		emf.createEntityManager();
		em.getTransaction().begin();
		
		Bar destroyedBar = em.find(Bar.class, barId);
		em.remove(destroyedBar);
		em.getTransaction().commit();
		itWorked = true;
	
		return itWorked;
	}

	@Override
	public List<Bar> findAllBars() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
