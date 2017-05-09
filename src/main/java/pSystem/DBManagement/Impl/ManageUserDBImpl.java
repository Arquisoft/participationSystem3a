package pSystem.DBManagement.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pSystem.DBManagement.ManageUserDB;
import pSystem.business.UserService;
import pSystem.model.User;

@Service
public class ManageUserDBImpl implements ManageUserDB {
	
	@Autowired
	private UserService userService;

	@Override
	public User addUser(User user) {
		return userService.addUser(user);
	}

	@Override
	public User findByUserAndPassword(String usuario, String contraseña) {
		return userService.findByUsernameAndPassword(usuario, contraseña);
	}

}
