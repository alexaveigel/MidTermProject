package com.skilldistillery.beerlab.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Service;

import com.skilldistillery.beerlab.entities.Drinker;
import com.skilldistillery.beerlab.entities.User;
@Service
public class UserDAOImpl implements UserDAO {

	private static EntityManagerFactory emf;
	private EntityManager em;

	static {
		emf = Persistence.createEntityManagerFactory("BeerQ");
	}

	@Override
	public User createUser(User user) {
		em = emf.createEntityManager();

		// start the transaction
		em.getTransaction().begin();
		
		String jpql = "SELECT user FROM User user WHERE user.username LIKE :bind";
		List<User> results = em.createQuery(jpql, User.class).setParameter("bind", "%" + user.getUsername() + "%")
				.getResultList();
		if (results.size() > 0) {
			return null;
		} else {
		// write the user to the database
		em.persist(user);
		// update the "local" user object
		em.flush();
		// commit the changes (actually perform the operation)
		em.getTransaction().commit();

		em.close();
		// return the beer object
		return user;
		}
	}
	
	@Override
	public Drinker createDrinker(Drinker drinker) {
		em = emf.createEntityManager();
		
		// start the transaction
		em.getTransaction().begin();
		

			// write the user to the database
			em.persist(drinker);
			// update the "local" user object
			em.flush();
			// commit the changes (actually perform the operation)
			em.getTransaction().commit();
			
			em.close();
			// return the beer object
			return drinker;
		
	}
	
	
	

	@Override
	public User updateUser(User user) {
		em = emf.createEntityManager();
		// open a transaction
		em.getTransaction().begin();

		// retrieve a "managed" User entity
		User updatedUser = em.find(User.class, user.getId());

		// update the values of the detached entity
		updatedUser.setUsername(user.getUsername());
		updatedUser.setPassword(user.getPassword());
		updatedUser.setRole(user.getRole());
		
		updatedUser.getDrinker().setFirstName(user.getDrinker().getFirstName());
		updatedUser.getDrinker().setLastName(user.getDrinker().getLastName());
		updatedUser.getDrinker().setDob(user.getDrinker().getDob());
		updatedUser.getDrinker().setGender(user.getDrinker().getGender());
		updatedUser.getDrinker().setBeerStyle(user.getDrinker().getBeerStyle());
		updatedUser.getDrinker().setPicUrl(user.getDrinker().getPicUrl());
		updatedUser.getDrinker().setAddressId(user.getDrinker().getAddressId());

		em.getTransaction().commit();
		em.close();
		return updatedUser;
	}
	
	@Override
	public Drinker updateDrinker(Drinker drinker, int addressId) {
		em = emf.createEntityManager();
		// open a transaction
		em.getTransaction().begin();
		// retrieve a "managed" Drinker entity
		Drinker updateDrinker = em.find(Drinker.class, drinker.getId());
		
		updateDrinker.setAddressId(drinker.getAddressId());
		
		em.getTransaction().commit();
		em.close();
		return updateDrinker;
	}

	@Override
	public boolean destroyUser(int userId) {
		
		boolean itWorked = false;
		em = emf.createEntityManager();
		em.getTransaction().begin();
		
		

		User destroyedUser = em.find(User.class, userId);
		em.remove(destroyedUser);
		em.getTransaction().commit();
		itWorked = true;

		return itWorked;
	}

	@Override
	public List<User> findAllUsers() {
		em = emf.createEntityManager();
		String jpql = "SELECT user FROM User user";
		List<User> users = em.createQuery(jpql, User.class).getResultList();

		return users;
	}

	@Override
	public List<User> findUserByUsername(String username) {
		em = emf.createEntityManager();
		
		String jpql = "SELECT user FROM User user WHERE user.username LIKE :bind";
		List<User> results = em.createQuery(jpql, User.class).setParameter("bind", "%" + username + "%")
				.getResultList();
		if (results.size() > 0) {
			em.close();
			return results;
		} else {
			em.close();
			return null;
		}

	}

	@Override
	public User findUserByUserNameAndPassword(String username, String password, User user) {
		em = emf.createEntityManager();
		System.out.println(em.find(User.class, 1));
		
		System.out.println("In dao: " + user);
		System.out.println(username + password);
		String jpql = "SELECT user FROM User user WHERE user.username = :bind1 AND user.password = :bind2";
		List<User> listUser = em.createQuery(jpql, User.class)
										.setParameter("bind1", user.getUsername())
										.setParameter("bind2", user.getPassword())
										.getResultList();
		System.out.println("in Dao ******************* " + user);
		if (listUser.size() > 0) {
			em.close();
			return listUser.get(0);
		} else {
			System.out.println(("In else statement of DAO **************************"));
			em.close();
			return null;
		}

	}
}
