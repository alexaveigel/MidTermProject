package com.skilldistillery.beerlab.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.beerlab.entities.User;

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

	@Override
	public int findUser(String user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User updateUser(int id, User user) {
		EntityManager em = emf.createEntityManager();
		// open a transaction
		em.getTransaction().begin();

		// retrieve a "managed" User entity
		User updatedUser = em.find(User.class, id);

		// update the values of the detached entity
		updatedUser.setUsername(user.getUsername());
		updatedUser.setPassword(user.getPassword());
		updatedUser.setRole(user.getRole());
	
		
		
		em.getTransaction().commit();
		em.close();
		return updatedUser;
	}

	@Override
	public boolean destroyUser(int userId) {
		boolean itWorked = false;
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		User destroyedUser = em.find(User.class, userId);
		em.remove(destroyedUser);
		em.getTransaction().commit();
		itWorked = true;
	
		return itWorked;
	}

}
