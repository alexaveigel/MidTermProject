package com.skilldistillery.beerlab.daos;

import com.skilldistillery.beerlab.entities.User;

public interface UserDAO {
	// Create
	public User createUser(User user);

	// Read
	public int findUser(String user);

	// Update
	public User updateUser(int id, User user);

	// Destroy
	public boolean destroyUser(int userId);

}
