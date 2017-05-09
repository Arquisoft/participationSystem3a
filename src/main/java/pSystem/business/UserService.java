package pSystem.business;

import pSystem.model.User;

public interface UserService {
	
	//CRUD
	public User addUser (User user);
	public void deleteUser (User user);
	public void updateUser (User user);
	public User findUser (Long userId);
	
	//Otros
	public User findByUsernameAndPassword(String username, String password);
	
}