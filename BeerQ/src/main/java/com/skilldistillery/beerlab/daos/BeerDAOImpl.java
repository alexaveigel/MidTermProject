package com.skilldistillery.beerlab.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.beerlab.entities.Beer;
import com.skilldistillery.beerlab.entities.User;

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
	public List<Beer>  findBeerByName(String beerName) {
		String query = "SELECT b FROM Beers b WHERE b.name LIKE :beerName";
		 List <Beer> beers =
			      em.createQuery(query, Beer.class)
			      .setParameter("term", "%"+beerName+"%")
			      .getResultList();
		return beers;
	}

	@Override
	public List<Beer>  findBeerByBrewery(String brewery) {
		String query = "SELECT b FROM Beers b WHERE b.brewery LIKE :brewery";
		 List <Beer> breweries =
			      em.createQuery(query, Beer.class)
			      .setParameter("brewery", "%"+brewery+"%")
			      .getResultList();
		return breweries;
	}

	@Override
	public List<Beer> findBeerByCity(String city) {
		String query = "FROM beer b JOIN  Bar_inventory bi ON bi.beer_id = b.id JOIN Bar on bi.bar_id =  Bar.id JOIN Address a on bar.address_id = a.id WHERE a.city = :city";
		 List <Beer> cities =
			      em.createQuery(query, Beer.class)
			      .setParameter("city", city)
			      .getResultList();
		return cities;
	}
	
	
	
	
	

	@Override
	public List<Beer> findAllBeers() {
		String query = "SELECT b FROM Beer b";
		List<Beer> beers = em.createQuery(query, Beer.class).getResultList();
		return beers;
	}

	@Override
	public Beer updateBeer(int id, Beer beer) {
		emf.createEntityManager();
		// open a transaction
		em.getTransaction().begin();

		// retrieve a "managed" Beer entity
		Beer updatedBeer = em.find(Beer.class, id);

		// update the values of the detached entity
		updatedBeer.setStyle(beer.getStyle());
		;
		updatedBeer.setName(beer.getName());
		updatedBeer.setAbv(beer.getAbv());
		updatedBeer.setBrewery(beer.getBrewery());
		updatedBeer.setDescription(beer.getDescription());

		em.getTransaction().commit();
		em.close();
		return updatedBeer;
	}

	@Override
	public boolean destroyBeer(int beerId) {
		boolean itWorked = false;
		emf.createEntityManager();
		em.getTransaction().begin();

		Beer destroyedBeer = em.find(Beer.class, beerId);
		em.remove(destroyedBeer);
		em.getTransaction().commit();
		itWorked = true;

		return itWorked;
	}

	@Override
	public List<Beer> addBeerToFavList(Beer beer, User user) {
		
		
		
		return favBeers;
	}

	@Override
	public List<Beer> getListOfFavBeer(User user) {
		
		
		
		return favBeers;
	}



}
