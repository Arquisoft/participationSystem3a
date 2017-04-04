package pSystem.DBManagement;

import org.springframework.beans.factory.annotation.Autowired;

import pSystem.model.Usuario;
import pSystem.persistence.UserRepository;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void addUser(Usuario user) {
		userRepository.save(user);
	}

}
