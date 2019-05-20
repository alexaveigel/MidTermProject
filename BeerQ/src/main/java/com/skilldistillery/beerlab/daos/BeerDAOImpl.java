package com.skilldistillery.beerlab.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import com.skilldistillery.beerlab.entities.Beer;
import com.skilldistillery.beerlab.entities.Brewery;
import com.skilldistillery.beerlab.entities.FavoriteBeer;
import com.skilldistillery.beerlab.entities.User;

@Service
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
	public List<Beer> findBeerByName(String beerName) {
		em = emf.createEntityManager();
		String query = "SELECT b FROM Beer b WHERE b.name LIKE :beerName";
		List<Beer> beers = em.createQuery(query, Beer.class).setParameter("beerName", "%" + beerName + "%")
				.getResultList();
		return beers;
	}

	@Override
	public List<Beer> findBeerByBrewery(String brewery) {
		em = emf.createEntityManager();
		String query = "SELECT b FROM Beer b WHERE b.brewery LIKE :brewery";
		List<Beer> breweries = em.createQuery(query, Beer.class).setParameter("brewery", "%" + brewery + "%")
				.getResultList();
		return breweries;
	}

	@Override
	public List<Beer> findBeerByCity(String city) {
		em = emf.createEntityManager();
//		String query = "SELECT beer FROM Beer beer "
//				+ "JOIN  Bar_inventory bi ON bi.beer_id = beer.id "
//				+ "JOIN Bar bar on bi.bar_id =  bar.id "
//				+ "JOIN Address address on bar.address_id = address.id WHERE address.city = :city";

		String jpql = "SELECT b from Beer b JOIN b.bars bars where bars.address.city = :city";

		List<Beer> cities = em.createQuery(jpql, Beer.class).setParameter("city", city).getResultList();

		for (Beer beer : cities) {
			System.out.println(beer);
		}

		return cities;
	}

	@Override
	public List<Beer> findAllBeers() {
		em = emf.createEntityManager();
		String query = "SELECT b FROM Beer b";
		List<Beer> beers = em.createQuery(query, Beer.class).getResultList();
		System.out.println("In beer DAO: " + beers);
		return beers;
	}

	@Override
	public List<Beer> approved() {
		em = emf.createEntityManager();
		String query = "SELECT fb FROM Favorite_Beer b WHERE fb.approved = 1";
		List<Beer> beers = em.createQuery(query, Beer.class).getResultList();
		return beers;
	}

	@Override
	public List<Beer> unapproved() {
		em = emf.createEntityManager();
		String query = "SELECT fb FROM Favorite_Beer b WHERE fb.approved = 0";
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
	public List<FavoriteBeer> addBeerToFavList(Beer beer, User user) {
		emf.createEntityManager();
		em.getTransaction().begin();
		User userFavBeer = em.find(User.class, user.getId());
		FavoriteBeer favBeer = em.find(FavoriteBeer.class, beer.getId());

		userFavBeer.getDrinker().getFavBeer().add(favBeer);

		em.getTransaction().commit();
		em.close();

		return userFavBeer.getDrinker().getFavBeer();
	}

	@Override
	public List<FavoriteBeer> getListOfFavBeer(User user) {
		emf.createEntityManager();
		em.getTransaction().begin();
		User userFavBeer = em.find(User.class, user.getId());

		return userFavBeer.getDrinker().getFavBeer();
	}

	@Override
	public List<Beer> approveBeer(Beer beer) {
		em = emf.createEntityManager();
		String query = "UPDATE Beer SET approved = 1 WHERE b.id = :beerId";
		List<Beer> approvedBeer = em.createQuery(query, Beer.class).setParameter("beerId", beer.getId())
				.getResultList();

		return approvedBeer;
	}

	@Override
	public List<Brewery> getBreweries() {
		em = emf.createEntityManager();
		String query = "SELECT brewery FROM Brewery brewery";
		List<Brewery> breweries = em.createQuery(query, Brewery.class).getResultList();

		return breweries;
	}

	@Override
	public List<Beer> getSixPack() {
		em = emf.createEntityManager();
		String query = "SELECT beer FROM Beer beer";
		List<Beer> beers = em.createQuery(query, Beer.class).getResultList();
		List<Beer> sixPack = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			sixPack.add(beers.get((int) (Math.random() + 1) * (beers.size() - 1)));
		}

		return sixPack;
	}

	@Override
	public List<String> getStyles() {
		em = emf.createEntityManager();
		String query = "SELECT distinct beer.style FROM Beer beer";
		List<String> styles = em.createQuery(query, String.class).getResultList();

		return styles;
	}

	@Override
	public List<Beer> getBeerByABV(double minAbv, double maxAbv) {
		em = emf.createEntityManager();
		String query = "SELECT beer FROM Beer beer where abv BETWEEN :bind1 and :bind2";
		List<Beer> beers = em.createQuery(query, Beer.class).setParameter("bind1", minAbv).setParameter("bind2", maxAbv)
				.getResultList();

		return beers;
	}

	@Override
	public List<Beer> getBeerByStyle(String style) {
		em = emf.createEntityManager();
		String query = "SELECT beer FROM Beer beer WHERE style = :bind ";
		List<Beer> beers = em.createQuery(query, Beer.class).setParameter("bind", style).getResultList();

		return beers;
	}

}
