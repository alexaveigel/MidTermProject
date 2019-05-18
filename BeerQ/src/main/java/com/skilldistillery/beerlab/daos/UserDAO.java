package com.skilldistillery.beerlab.daos;

import java.util.List;

import com.skilldistillery.beerlab.entities.User;

public interface UserDAO {
	// Create
	public User createUser(User user);

	// Read
	public User findUserByUserNameAndPassword(String username, String password);

	// Update
	public User updateUser(User user);

	// Destroy
	public boolean destroyUser(int userId);
	
	//Read
	public List<User> findAllUsers();
	
	//Read
	public User findUserByUsername(String username);

}
