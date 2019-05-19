package com.skilldistillery.beerlab.daos;

import java.util.List;

import com.skilldistillery.beerlab.entities.Drinker;
import com.skilldistillery.beerlab.entities.User;

public interface UserDAO {
	// Create
	public User createUser(User user);

	// Read
	public User findUserByUserNameAndPassword(String username, String password, User user);

	// Update
	public User updateUser(User user);

	// Destroy
	public boolean destroyUser(int userId);
	
	//Read
	public List<User> findAllUsers();
	
	//Read
	public List<User> findUserByUsername(String username);

	public Drinker createDrinker(Drinker drinker);

}
