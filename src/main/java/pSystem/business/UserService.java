package pSystem.business;

import pSystem.model.User;

public interface UserService {
	
	public User addUser(User user);
	public User findByUserAndPassword(String usuario, String contraseña);
	
}