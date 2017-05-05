package pSystem.DBManagement;

import pSystem.model.User;

public interface ManageUserDB {
	
	public User addUser(User user);
	public User findByUserAndPassword(String usuario, String contraseña);
}
