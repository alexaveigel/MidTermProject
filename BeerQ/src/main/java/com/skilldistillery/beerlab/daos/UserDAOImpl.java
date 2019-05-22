package com.skilldistillery.beerlab.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.beerlab.entities.Drinker;
import com.skilldistillery.beerlab.entities.User;

@Service
@Transactional
public class UserDAOImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public User createUser(User user) {

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
			// return the beer object
			return user;
		}
	}

	@Override
	public Drinker createDrinker(Drinker drinker) {
		// write the user to the database
		em.persist(drinker);
		// update the "local" user object
		em.flush();
		// return the beer object
		return drinker;

	}

	@Override
	public User updateUser(User user) {
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

		updatedUser.getDrinker().getAddress().setStreet(user.getDrinker().getAddress().getStreet());
		updatedUser.getDrinker().getAddress().setStreet(user.getDrinker().getAddress().getCity());
		updatedUser.getDrinker().getAddress().setStreet(user.getDrinker().getAddress().getState());
		updatedUser.getDrinker().getAddress().setStreet(user.getDrinker().getAddress().getZip());
		updatedUser.getDrinker().getAddress().setStreet(user.getDrinker().getAddress().getCountry());
		updatedUser.getDrinker().getAddress().setStreet(user.getDrinker().getAddress().getLatitude());
		updatedUser.getDrinker().getAddress().setStreet(user.getDrinker().getAddress().getLongitude());

		return updatedUser;
	}

	@Override
	public Drinker updateDrinker(Drinker drinker, int id) {
		// retrieve a "managed" Drinker entity
		Drinker updateDrinker = em.find(Drinker.class, id);

		if (drinker.getAddress() != null) {
			updateDrinker.setAddress(drinker.getAddress());

		}
		updateDrinker.setFirstName(drinker.getFirstName());
		updateDrinker.setLastName(drinker.getLastName());
		updateDrinker.setDob(drinker.getDob());
		updateDrinker.setBeerStyle(drinker.getBeerStyle());
		updateDrinker.setGender(drinker.getGender());
		updateDrinker.setPicUrl(drinker.getPicUrl());

		return updateDrinker;
	}

	@Override
	public boolean destroyUser(int userId) {

		boolean itWorked = false;

		User destroyedUser = em.find(User.class, userId);
		em.remove(destroyedUser);
		itWorked = true;
		return itWorked;
	}

	@Override
	public List<User> findAllUsers() {
		String jpql = "SELECT user FROM User user";
		List<User> users = em.createQuery(jpql, User.class).getResultList();
		return users;
	}

	@Override
	public List<User> findUserByUsername(String username) {

		String jpql = "SELECT user FROM User user WHERE user.username LIKE :bind";
		List<User> results = em.createQuery(jpql, User.class).setParameter("bind", "%" + username + "%")
				.getResultList();
		if (results.size() > 0) {
			return results;
		} else {
			return null;
		}

	}

	@Override
	public User findUserByUserNameAndPassword(String username, String password, User user) {

		String jpql = "SELECT user FROM User user WHERE user.username = :bind1 AND user.password = :bind2";
		List<User> listUser = em.createQuery(jpql, User.class).setParameter("bind1", user.getUsername())
				.setParameter("bind2", user.getPassword()).getResultList();
		if (listUser.size() > 0) {
			return listUser.get(0);
		} else {
			return null;
		}

	}
}
