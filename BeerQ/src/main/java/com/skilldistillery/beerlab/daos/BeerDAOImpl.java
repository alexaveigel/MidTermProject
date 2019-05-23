package com.skilldistillery.beerlab.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.mysql.cj.Session;
import com.skilldistillery.beerlab.entities.Beer;
import com.skilldistillery.beerlab.entities.Brewery;
import com.skilldistillery.beerlab.entities.Drinker;
import com.skilldistillery.beerlab.entities.FavoriteBeer;

@Service
@Transactional
public class BeerDAOImpl implements BeerDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Beer createBeer(Beer beer) {

		// write the beer to the database
		em.persist(beer);
		// update the "local" address object
		em.flush();

		// return the beer object
		return beer;
	}

	@Override
	public List<Beer> findBeerByName(String beerName) {
		String query = "SELECT b FROM Beer b WHERE b.approved = 1 AND b.name LIKE :beerName ";
		List<Beer> beers = em.createQuery(query, Beer.class).setParameter("beerName", "%" + beerName + "%")
				.getResultList();
		return beers;
	}

	@Override
	public List<Beer> findBeerByBrewery(String brewery) {
		String query = "SELECT b FROM Beer b WHERE b.brewery LIKE :brewery";
		List<Beer> breweries = em.createQuery(query, Beer.class).setParameter("brewery", "%" + brewery + "%")
				.getResultList();
		return breweries;
	}

	@Override
	public List<Beer> findBeerByCity(String city) {

		String jpql = "SELECT b from Beer b JOIN b.bars bars where bars.address.city = :city AND b.approved = 1";

		List<Beer> cities = em.createQuery(jpql, Beer.class).setParameter("city", city).getResultList();

		for (Beer beer : cities) {
			System.out.println(beer);
		}

		return cities;
	}

	@Override
	public List<Beer> findAllBeers() {
		String query = "SELECT b FROM Beer b";
		List<Beer> beers = em.createQuery(query, Beer.class).getResultList();
		System.out.println("In beer DAO: " + beers);
		return beers;
	}

	@Override
	public List<Beer> approved() {
		String query = "SELECT b FROM Beer b WHERE b.approved = 1";
		List<Beer> beers = em.createQuery(query, Beer.class).getResultList();
		return beers;
	}

	@Override
	public List<Beer> unapproved() {
		String query = "SELECT b FROM Beer b WHERE b.approved = 0";
		List<Beer> beers = em.createQuery(query, Beer.class).getResultList();
		return beers;
	}

	@Override
	public Beer updateBeer(int id, Beer beer) {
		// open a transaction

		// retrieve a "managed" Beer entity
		Beer updatedBeer = em.find(Beer.class, id);

		// update the values of the detached entity
		updatedBeer.setStyle(beer.getStyle());
		;
		updatedBeer.setName(beer.getName());
		updatedBeer.setAbv(beer.getAbv());
		updatedBeer.setBrewery(beer.getBrewery());
		updatedBeer.setDescription(beer.getDescription());

		return updatedBeer;
	}

	@Override
	public boolean destroyBeer(int beerId) {
		boolean itWorked = false;
		Beer destroyedBeer = em.find(Beer.class, beerId);
		em.remove(destroyedBeer);
		itWorked = true;

		return itWorked;
	}

	@Override
	public List<FavoriteBeer> addBeerToFavList(Beer beer, HttpSession session) {
		Drinker drinker = (Drinker) session.getAttribute("drinker");
		drinker = em.find(Drinker.class, drinker.getId());
		FavoriteBeer favBeer = new FavoriteBeer();
		favBeer.setBeer(beer);
		favBeer.setDrinker(drinker);
		em.persist(favBeer);
		em.flush();
		drinker.getBeers().add(favBeer);
		System.out.println(drinker.getBeers());

		return drinker.getFavBeer();
	}

	@Override
	public List<FavoriteBeer> getListOfFavBeer(HttpSession session) {
		Drinker drinker = (Drinker) session.getAttribute("drinker");
		System.out.println(drinker);
		System.out.println(drinker.getBeers());
		return drinker.getBeers();
	}

	@Override
	public List<Brewery> getRandomBreweries() {
		String query = "SELECT * FROM brewery ORDER BY RAND() LIMIT 20";
		List<Brewery> random = em.createNativeQuery(query, Brewery.class).getResultList();

		return random;
	}

	@Override
	public Beer approveBeer(int beerId) {

		Beer approvedBeer = em.find(Beer.class, beerId);
		approvedBeer.setApproved(1);

		return approvedBeer;

	}
	@Override
	public Beer unapproveBeer(int beerId) {
		
		Beer approvedBeer = em.find(Beer.class, beerId);
		approvedBeer.setApproved(0);
		
		return approvedBeer;
		
	}

	@Override
	public List<Brewery> getBreweries() {
		String query = "SELECT brewery FROM Brewery brewery";
		List<Brewery> breweries = em.createQuery(query, Brewery.class).getResultList();

		return breweries;
	}

	@Override
	public List<Beer> getSixPack() {

		String query = "SELECT * FROM beer ORDER BY RAND() LIMIT 6";
		List<Beer> sixPack = em.createNativeQuery(query, Beer.class).getResultList();
		return sixPack;
	}

	@Override
	public List<String> getStyles() {
		String query = "SELECT distinct beer.style FROM Beer beer ORDER BY beer.style";
		List<String> styles = em.createQuery(query, String.class).getResultList();

		return styles;
	}

	@Override
	public List<Beer> getBeerByABV(double minAbv, double maxAbv) {
		String query = "SELECT beer FROM Beer beer where abv BETWEEN :bind1 and :bind2";
		List<Beer> beers = em.createQuery(query, Beer.class).setParameter("bind1", minAbv).setParameter("bind2", maxAbv)
				.getResultList();

		return beers;
	}

	@Override
	public List<Beer> getBeerByStyle(String style) {
		String query = "SELECT beer FROM Beer beer WHERE style = :bind ";
		List<Beer> beers = em.createQuery(query, Beer.class).setParameter("bind", style).getResultList();

		return beers;
	}

	@Override
	public Beer findBeerById(int beerId) {
		Beer beer = em.find(Beer.class, beerId);
		return beer;
	}

	@Override
	public FavoriteBeer findFavBeerById(int beerId) {
		FavoriteBeer favBeer = em.find(FavoriteBeer.class, beerId);
		return favBeer;
	}

	@Override
	public boolean removeBeerFromFavs(FavoriteBeer favBeer, HttpSession session) {
		boolean itWorked = false;
		Drinker drinker = em.find(Drinker.class, ((Drinker) (session.getAttribute("drinker"))).getId());
		FavoriteBeer removedBeer = em.find(FavoriteBeer.class, favBeer.getId());
		em.remove(removedBeer);
		drinker.getBeers().remove(removedBeer);
		em.persist(drinker);
		session.setAttribute("drinker", drinker);
		itWorked = true;

		return itWorked;
	}

}
