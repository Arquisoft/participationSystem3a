package pSystem.DBManagement.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pSystem.DBManagement.UserService;
import pSystem.model.User;
import pSystem.persistence.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByUserAndPassword(String usuario, String contraseña) {
		return userRepository.findByUserAndPassword(usuario, contraseña);
	}
}