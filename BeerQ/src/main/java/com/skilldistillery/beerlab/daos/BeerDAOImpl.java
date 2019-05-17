package com.skilldistillery.beerlab.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.beerlab.entities.Beer;

public class BeerDAOImpl implements BeerDAO {
	
	private static EntityManagerFactory emf;
	private EntityManager em;

	static {
		emf = Persistence.createEntityManagerFactory("BeerQ");
	}

	@Override
	public Beer createBeer(Beer beer) {
		em = emf.createEntityManager();

		// start the transaction
		em.getTransaction().begin();
		// write the beer to the database
		em.persist(beer);
		// update the "local" address object
		em.flush();
		// commit the changes (actually perform the operation)
		em.getTransaction().commit();

		em.close();
		// return the beer object
		return beer;
	}

	@Override
	public int findBeerName(String beerName) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Beer updateBeer(int id, Beer beer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean destroyBeer(int beerId) {
		boolean itWorked = false;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		Beer destroyedBeer = em.find(Beer.class, beerId);
		em.remove(destroyedBeer);
		em.getTransaction().commit();
		itWorked = true;
	
		return itWorked;
	}


}
